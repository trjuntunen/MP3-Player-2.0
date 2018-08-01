import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;

public class Frame {

	private JFrame frame;
	private JList songList;
	private SongList songs;
	
	public Frame(SongList songs) {
		this.songs = songs;
		songList = new JList<String>();
		frame = new JFrame("MP3 Player");
	}
	
	public void setup() {
		
		/* Add all the components inside the frame */
		setupSongList();
		frame.add(songList);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private void setupSongList() {
		ArrayList<String> songTitleList = new ArrayList<String>();
		for(int i = 0; i < songs.size(); i++) {
			String songTitle = songs.get(i).getTitle();
			songTitleList.add(songTitle);
		}
		songList = new JList(songTitleList.toArray());
	}

}
