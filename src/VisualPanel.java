import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VisualPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel label;
	private ImageIcon albumCover;

	public VisualPanel() {
		setup();
	}

	private void setup() {
		label = new JLabel();
		albumCover = new ImageIcon("src/resources/noAlbum.jpg");
		label.setIcon(albumCover);
		add(label);
	}

	public void setLabelImage(ImageIcon newAlbumCover) {
		albumCover = newAlbumCover;
		label.setIcon(albumCover);
	}

}
