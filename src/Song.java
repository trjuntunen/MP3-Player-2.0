import java.nio.file.Path;
import javax.swing.ImageIcon;

public class Song {

	private String title;
	private String artist;
	private String album;
	private ImageIcon albumCover;
	private Path path;

	public Song(String title, String artist, String album, ImageIcon albumCover, Path path) {
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.albumCover = albumCover;
		this.path = path;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String newTitle) {
		title = newTitle;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String newArtist) {
		artist = newArtist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String newAlbum) {
		album = newAlbum;
	}
	
	public ImageIcon getAlbumCover() {
		return albumCover;
	}

	public Path getPath() {
		return path;
	}

}
