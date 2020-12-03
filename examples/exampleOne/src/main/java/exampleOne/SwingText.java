package exampleOne;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/***
 * @author Kessler Yaron Swing Button Text Example.
 */
public class SwingText extends JFrame {

	private JFrame frame;
	private JScrollPane panelScroll;
	private JPanel panel;
	private JLabel lblOne;
	private JTextField textCheck;
	private JButton buttonOne;
	private JFormattedTextField jfTextField;

	int frameX = 1;
	int frameY = 1;

//	private Graphics G;

	public SwingText() {

		frame = new JFrame();
		frame.setSize(450, 300);
		frame.setTitle("java text tricks");

		/// Frame-Centered
		frameCentered();
		// frame.setLocationRelativeTo(null);

		panel = new JPanel();
		panel.setLayout(null);

		lblOne = new JLabel();
		lblOne.setText("press a value (12..., abc..., ABC...)");
		lblOne.setBounds(10, 10, 240, 22);
		panel.add(lblOne);

		textCheck = new JTextField();

		textCheck.setBounds(10, 35, 240, 22);
		textCheck.setToolTipText("enter a number -or- text upperCase, lowerCase");
		panel.add(textCheck);
//		textCheck.isValid();

		jfTextField = new JFormattedTextField();
		jfTextField.setBounds(10, 70, 150, 22);
		panel.add(jfTextField);

		jfTextField.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				System.out.println("clicked >>> " + jfTextField.getText());
			}
		});

		buttonOne = new JButton();
		buttonOne.setText("click");
		// buttonOne.setRotation(-90);
		buttonOne.setBounds(10, 105, 150, 50);
		panel.add(buttonOne);

		
////---------------------------------------------------------------
		// TODO
		// for this to work fix this code "panel.setLayout(null);" 
		// somthing other then null
//		panelScroll = new JScrollPane(panel, 
//				panelScroll.VERTICAL_SCROLLBAR_AS_NEEDED, 
//				panelScroll.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		
//		panelScroll.add(panel)sdaf
////---------------------------------------------------------------
			
		
//		textCheck.requestFocus();
		jfTextField.requestFocus();
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/***
	 * frameCentered() - frame in center of screen.
	 */
	public void frameCentered() {
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolKit.getScreenSize();
		frameX = ((dimension.width / 2) - (frame.getWidth() / 2));
		frameY = ((dimension.height / 2) - (frame.getHeight() / 2));

		frame.setLocation(frameX, frameY);
	}

}
