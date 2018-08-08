import java.io.FileInputStream;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class SongController {

	private boolean songIsPlaying;
	private FileInputStream songInputStream;
	private Thread thread;
	private AdvancedPlayer player;
	private int timeLeft;
	private int total;
	private Song currentSong;

	public SongController() {
		songIsPlaying = false;
		timeLeft = 0;
		total = 0;
	}

	public void play(Song song) {
		try {
			songInputStream = new FileInputStream(song.getPath().toString());
			player = new AdvancedPlayer(songInputStream);
			playStreamOnNewThread();
			currentSong = song;
			total = songInputStream.available();
		} catch (JavaLayerException | IOException e) {
			e.printStackTrace();
		}
	}

	public void pause() {
		if(songIsPlaying) {
			try {
				timeLeft = songInputStream.available();
				player.close();
				songIsPlaying = false;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				songInputStream = new FileInputStream(currentSong.getPath().toString());
				songInputStream.skip(total - timeLeft);
				player = new AdvancedPlayer(songInputStream);
				playStreamOnNewThread();
			} catch (IOException | JavaLayerException e) {
				e.printStackTrace();
			}
		}
	}

	public void stop() {
		if(songIsPlaying) {
			player.close();
			songIsPlaying = false;
		}
	}

	private void playStreamOnNewThread() {
		if(songIsPlaying) {
			thread.stop();
		}
		thread = new Thread() {
			public void run() {
				try {
					Thread.sleep(500);
					player.play();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
		songIsPlaying = true;
	}

	public boolean songIsPlaying() {
		return songIsPlaying;
	}

}


