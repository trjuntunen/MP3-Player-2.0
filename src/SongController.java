import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class SongController {

	 private boolean songIsPlaying;
	 private AdvancedPlayer player;
	 private Thread thread;
	 
	 public SongController() {
		 songIsPlaying = false;
	 }
	
	public void play(Song song) {
		try {
			String songPath = song.getPath().toString();
			FileInputStream songInputStream = new FileInputStream(songPath);
			player = new AdvancedPlayer(songInputStream);
			playSongOnSeparateThread(player);
		} catch (FileNotFoundException | JavaLayerException e) {
			e.printStackTrace();
		}

	}
	
	public void stop() {
		thread.stop();
		songIsPlaying = false;
	}

	public void playSongOnSeparateThread(AdvancedPlayer player) {
		thread = new Thread() {
			public void run() {
				try {
					player.play();
				} catch (JavaLayerException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
	}
	
	public void setSongIsPlaying(boolean isPlaying) {
		songIsPlaying = isPlaying;
	}
	
	public boolean songIsPlaying() {
		return songIsPlaying;
	}

}


