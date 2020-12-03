package exampleTwo;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class VerticalRotationSSCCE {

	private static class VerticalTextField extends JTextField {

	    private static final long serialVersionUID = 1L;

	    public VerticalTextField(String text) {
	        super(text);
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        Graphics2D g2 = (Graphics2D) g;
	        int cx = getWidth() / 2;
	        int cy = getHeight() / 2;
	        g2.rotate(1/2 * Math.PI, cx, cy);
	        super.paintComponent(g2);
	    }

	}

	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {

//	        @Override
	        public void run() {
	            JFrame frame = new JFrame();
	            frame.setSize(500, 500);
	            frame.getContentPane().add(new VerticalTextField("Foo Foo Is Not That Good"));
	            frame.pack();
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setVisible(true);
	        }

	    });
	}
}
