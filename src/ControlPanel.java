import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
	
	JButton previousButton;
	JButton nextButton;
	JButton pauseButton;
	JButton stopButton;
	
	public ControlPanel() {
		setup();
	}
	
	private void setup() {
		setupPauseButton();
	}
	
	private void setupPauseButton() {
		pauseButton = new JButton();
		pauseButton.setIcon(new ImageIcon("C:\\Users\\epbba\\Desktop\\Stuff\\Programming\\Projects\\MP3-Player-2.0\\pauseButton.png"));
		add(pauseButton);
	}
	
}
