import java.nio.file.Path;
import java.nio.file.Paths;

public class Driver {

	public static void main(String[] args) {
		SongList songs = new SongList();
		Path path = Paths.get("D:\\Music");
		songs.build(path);

		MusicPlayerFrame frame = new MusicPlayerFrame(songs);
		frame.show();
	}

}
