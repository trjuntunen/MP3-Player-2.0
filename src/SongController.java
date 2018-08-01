import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class SongController {

	public void play(Song song) {
		do {
			try {
				String songPath = song.getPath().toString();
				FileInputStream songInputStream = new FileInputStream(songPath);
				AdvancedPlayer player = new AdvancedPlayer(songInputStream);
				player.play();
			} catch (FileNotFoundException | JavaLayerException e) {
				e.printStackTrace();
			}

		} while(true);
	}
	
}


