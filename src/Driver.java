
public class Driver {

	public static void main(String[] args) {
		SongList songs = new SongList();
		Frame frame = new Frame(songs);
		songs.build();
		frame.setup();
	}

}
