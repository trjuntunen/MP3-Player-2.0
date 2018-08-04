import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;

public class Frame {

	private JFrame frame;
	private JList<String> songList;
	private SongList songs;
	private SongController controller;
	
	public Frame(SongList songs) {
		this.songs = songs;
		songList = new JList<String>();
		frame = new JFrame("MP3 Player");
		controller = new SongController();
	}
	
	public void setup() {
		setupSongList();
		frame.add(songList);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
	
	public void show() {
		frame.setVisible(true);
	}
	
	private void setupSongList() {
		ArrayList<String> songTitleList = new ArrayList<String>();
		for(int i = 0; i < songs.size(); i++) {
			String songTitle = songs.get(i).getTitle();
			songTitleList.add(songTitle);
		}
		
		/* Convert the ArrayList<String> to a String[] to add to the JList. */
		String[] songTitleArray = songTitleList.toArray(new String[songTitleList.size()]);
		songList = new JList<String>(songTitleArray);
		
		addDoubleClickListenerToPlaySong();
		
	}
	
	private void addDoubleClickListenerToPlaySong() {
		songList.addMouseListener(new MouseAdapter() {
			
		    public void mouseClicked(MouseEvent event) {
		        JList<String> list = (JList<String>) event.getSource();
		        if (event.getClickCount() == 2) {
		            int index = list.locationToIndex(event.getPoint());
		            controller.play(songs.get(index));
		        }
		    }
		});
	}

}
