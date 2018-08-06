import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MusicPlayerFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private SongList songs;
	
	public MusicPlayerFrame(SongList songList) {
		frame = new JFrame("MP3 Player");
		songs = songList;
		setup();
	}

	private void setup() {
		VisualPanel visualPanel = new VisualPanel();
		EventManagement event = new EventManagement(visualPanel);
		SongPanel songPanel = new SongPanel(songs, event);
		ControlPanel controlPanel = new ControlPanel();
		frame.add(songPanel, BorderLayout.CENTER);
		frame.add(visualPanel, BorderLayout.NORTH);
		frame.add(controlPanel, BorderLayout.SOUTH);
		frame.pack();
		frame.setMinimumSize(new Dimension(600, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

	public void show() {
		frame.setVisible(true);
	}

}
