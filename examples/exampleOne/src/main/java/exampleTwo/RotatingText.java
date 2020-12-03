package exampleTwo;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
  
public class RotatingText
{
    public static void main(String[] args)
    {
        RotatingTextPanel textPanel = new RotatingTextPanel();
        RotationWrangler wrangler = textPanel.wrangler;
        JFrame f = new JFrame("click on white");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(wrangler.getTextPanel(), "North");
        f.getContentPane().add(textPanel);
        f.getContentPane().add(wrangler.getInputPanel(), "South");
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);
    }
}
  
class RotatingTextPanel extends JPanel
{
    double theta;
    boolean showBounds;
    String text;
    int x, y;
    Font font;
    RotationWrangler wrangler;
  
    public RotatingTextPanel()
    {
        theta = 0;
        showBounds = false;
        text = "";
        x = y = 0;
        font = new Font("lucida sans regular", Font.PLAIN, 18);
        wrangler = new RotationWrangler(this);
        addMouseListener(wrangler);
        setBackground(Color.white);
    }
  
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(font);
        g2.rotate(theta, x, y);
        g2.drawString(text, x, y);
        System.out.println("text = " + text + "\tx = " + x + "\ty = " + y);
        if(showBounds)
        {
            FontRenderContext frc = g2.getFontRenderContext();
            float textWidth = (float)font.getStringBounds(text, frc).getWidth();
            LineMetrics lm = font.getLineMetrics(text, frc);
            float ascent = lm.getAscent();
            float descent = lm.getDescent();
            float height = ascent + descent;
            Rectangle2D r = new Rectangle2D.Double(x, y - ascent, textWidth, height);
            g2.setPaint(Color.red);
            g2.draw(r);
        }
    }
  
    public void setLocation(Point p)
    {
        x = p.x;
        y = p.y;
        text = wrangler.getText();
        repaint();
    }
  
    public void setShowBounds(boolean isVisible)
    {
        showBounds = isVisible;
    }
  
    public void setAngle(int degrees)
    {
        theta = Math.toRadians(degrees);
    }
}
  
class RotationWrangler extends MouseAdapter
{
    RotatingTextPanel textPanel;
    JTextField textField;
  
    public RotationWrangler(RotatingTextPanel rtp)
    {
        textPanel = rtp;
    }
  
    public void mousePressed(MouseEvent e)
    {
        textPanel.setLocation(e.getPoint());
    }
  
    public String getText()
    {
        return textField.getText();
    }
  
    public JPanel getTextPanel()
    {
        textField = new JTextField("hello world", 6);
        JPanel panel = new JPanel();
        panel.add(new JLabel("enter string"));
        panel.add(textField);
        return panel;
    }
  
    public JPanel getInputPanel()
    {
        final JCheckBox boundsBox = new JCheckBox("show bounds");
        boundsBox.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                textPanel.setShowBounds(boundsBox.isSelected());
            }
        });
        final SpinnerNumberModel model = new SpinnerNumberModel(0, -180, 180, 10);
        JSpinner spinner = new JSpinner(model);
        spinner.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
                int angle = model.getNumber().intValue();
                textPanel.setAngle(angle);
            }
        });
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2,2,2,2);
        gbc.weightx = 1.0;
        panel.add(boundsBox, gbc);
        gbc.anchor = gbc.EAST;
        panel.add(new JLabel("angle"), gbc);
        gbc.anchor = gbc.WEST;
        panel.add(spinner, gbc);
        return panel;
    }
}