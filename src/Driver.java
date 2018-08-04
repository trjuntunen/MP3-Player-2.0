import java.nio.file.Path;
import java.nio.file.Paths;

public class Driver {

	public static void main(String[] args) {
		SongList songs = new SongList();
		Frame frame = new Frame(songs);
		
		Path pathToSearchForMp3Files = Paths.get("/Users/tedjuntunen/Desktop");
		songs.build(pathToSearchForMp3Files);
		
		frame.setup();
		frame.show();
		
	}

}
