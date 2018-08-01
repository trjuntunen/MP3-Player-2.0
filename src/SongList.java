import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

public class SongList {

	private ArrayList<Song> songs;
	private ArrayList<File> mp3Files;

	public SongList() {
		songs = new ArrayList<Song>();
		mp3Files = new ArrayList<File>();
	}

	public void build() {
		Path path = Paths.get("/Users/tedjuntunen/Desktop");
		buildMp3FileList(path);
		for(File mp3File: mp3Files) {
			Song song = createSongFromFile(mp3File);
			if(songHasEmptyValues(song)) {
				song.setTitle(song.getPath().toString());
				song.setArtist("Unknown");
				song.setAlbum("Unknown");
			}
			songs.add(song);
		}
	}

	private boolean songHasEmptyValues(Song song) {
		if(song.getTitle() != "" && song.getArtist() != "" && song.getAlbum() != "") {
			return false;
		}
		return true;
	}

	private Song createSongFromFile(File mp3File) {
		Song song = null;
		try {
			AudioFile f = AudioFileIO.read(mp3File);
			Tag tag = f.getTag();
			
			/* Get the 4 required fields from the file metadata */
			String title = tag.getFirst(FieldKey.TITLE);
			String artist = tag.getFirst(FieldKey.ARTIST);
			String album = tag.getFirst(FieldKey.ALBUM);
			Path path = mp3File.toPath();
			
			song = new Song(title, artist, album, path);
		} catch (CannotReadException | IOException | TagException | ReadOnlyFileException
				| InvalidAudioFrameException e) {
			e.printStackTrace();
		}
		return song;
	}

	private void buildMp3FileList(Path path) {
		buildMp3FileList(path.toFile());
	}

	private void buildMp3FileList(File file) {
		File[] allFilesInDirectory = file.listFiles();
		if(file.isFile()) {
			int lastIndexOfPeriod = file.getName().lastIndexOf('.');
			String fileExtension = file.getName().substring(lastIndexOfPeriod + 1);
			if(fileExtension.equals("mp3")) {
				mp3Files.add(file);
			}
		} else if(file.isDirectory()) {
			for(File f: allFilesInDirectory) {
				buildMp3FileList(f);
			}
		}
	}

	public Song get(int index) {
		return songs.get(index);
	}
	
	public int size() {
		return songs.size();
	}

}
