import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class SongController {

	public void play(Song song) {
		try {
			String songPath = song.getPath().toString();
			FileInputStream songInputStream = new FileInputStream(songPath);
			AdvancedPlayer player = new AdvancedPlayer(songInputStream);
			playSongOnSeparateThread(player);
		} catch (FileNotFoundException | JavaLayerException e) {
			e.printStackTrace();
		}

	}

	public void playSongOnSeparateThread(AdvancedPlayer player) {
		Thread thread = new Thread() {
			public void run() {
				try {
					player.play();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
	}

}


