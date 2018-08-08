import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class LoadingWindow extends JWindow {

	private static final long serialVersionUID = 1L;

	public LoadingWindow() {
		setup();
		runLoadingScreenThread();
	}

	private void runLoadingScreenThread() {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				setVisible(true);
			} 
		});
	}
	

	private void setup() {
		setLocationRelativeTo(null);
		setBounds(0, 0, 400, 300);
		centerWindow(this);
		addGif();
	}

	private void addGif() {
		Icon icon = new ImageIcon("src/resources/loadingCircle.gif");
		JLabel label = new JLabel(icon);
		label.setMaximumSize(new Dimension(50, 50));
		add(label);
	}

	private void centerWindow(Window frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
	}

}
