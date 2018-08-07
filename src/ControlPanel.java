import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
	
	private JButton previousButton;
	private JButton nextButton;
	private JButton pauseButton;
	private JButton stopButton;
	private SongController controller;
	
	public ControlPanel(SongController controller) {
		this.controller = controller;
		setup();
	}
	
	private void setup() {
		setupPauseButton();
	}
	
	private void setupPauseButton() {
		pauseButton = new JButton();
		pauseButton.setIcon(new ImageIcon("C:\\Users\\epbba\\Desktop\\Stuff\\Programming\\Projects\\MP3-Player-2.0\\pauseButton.png"));
		addClickListenerToPauseButton();
		add(pauseButton);
	}
	
	public void addClickListenerToPauseButton() {
		pauseButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				if(event.getClickCount() == 1) {
					controller.stop();
				}
			}
		});
	}
	
}
