import javax.swing.ImageIcon;

public class EventManagement {

	private VisualPanel visualPanel;

	public EventManagement(VisualPanel visualPanel) {
		this.visualPanel = visualPanel;
	}

	public void setLabelImage(ImageIcon albumCover) {
		visualPanel.setLabelImage(albumCover);
	}

}
