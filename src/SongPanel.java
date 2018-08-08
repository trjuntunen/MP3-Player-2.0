import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SongPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JList<String> songs;
	private SongList songList;
	private SongController controller;
	private EventManagement eventManage;

	public SongPanel(SongList songList, EventManagement eventManage, SongController controller) {
		this.songList = songList;
		this.eventManage = eventManage;
		this.controller = controller;
		setup();
	}

	private void setup() {
		setupSongList();
		setupScrollPane();
		setLayout(new GridLayout(0, 1));
	}
	
	private void setupSongList() {
		songs = new JList<String>(songList.getSongTitles());
		addDoubleClickListenerToList();
	}

	private void setupScrollPane() {
		scrollPane = new JScrollPane(songs);
		add(scrollPane);
	}

	public void addDoubleClickListenerToList() {
		songs.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				JList<String> list = (JList<String>) event.getSource();
				if (event.getClickCount() == 2) {
					int index = list.locationToIndex(event.getPoint());
					Song song = songList.get(index);
					eventManage.setLabelImage(song.getAlbumCover());
					controller.play(song);
				}
			}
		});
	}

}
