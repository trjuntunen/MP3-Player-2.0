import java.nio.file.Path;
import java.nio.file.Paths;

public class Driver {

	public static void main(String[] args) {
		SongList songs = new SongList();
		String desktopPath = javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath() + "/desktop";

		Path path = Paths.get(desktopPath);
		LoadingWindow loadingWindow = new LoadingWindow();

		songs.build(path);
		songs.sort();

		loadingWindow.setVisible(false);

		MusicPlayerFrame frame = new MusicPlayerFrame(songs);
		frame.show();
	}

}
