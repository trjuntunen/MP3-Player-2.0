import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {

	private JButton previousButton, nextButton, pauseButton, stopButton;
	private SongController controller;
	private final ImageIcon PLAY_BUTTON = new ImageIcon("src/resources/playButton.png");
	private final ImageIcon PAUSE_BUTTON = new ImageIcon("src/resources/pauseButton.png");

	public ControlPanel(SongController controller) {
		this.controller = controller;
		setup();
	}

	private void setup() {
		setupPauseButton();
	}

	private void setupPauseButton() {
		pauseButton = new JButton();
		pauseButton.setIcon(PLAY_BUTTON);
		addClickListenerToPauseButton();
		add(pauseButton);
	}

	private void addClickListenerToPauseButton() {
		pauseButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				if(event.getClickCount() == 1) {
					controller.pause();
				}
			}
		});
	}

}
