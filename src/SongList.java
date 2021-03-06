import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;

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

	public void build(Path pathToSearchForMp3Files) {
		buildMp3FileList(pathToSearchForMp3Files);
		for(File mp3File: mp3Files) {
			try {
				AudioFile audioFile = AudioFileIO.read(mp3File);
				Tag tag = audioFile.getTag();
				String title = tag.getFirst(FieldKey.TITLE);
				String artist = tag.getFirst(FieldKey.ARTIST);
				String album = tag.getFirst(FieldKey.ALBUM);
				Image resizedAlbumImage = tag.getFirstArtwork().getImage().getScaledInstance(300, 300, 0);
				ImageIcon albumCover = new ImageIcon(resizedAlbumImage);
				Path path = Paths.get(mp3File.getAbsolutePath());
				Song song = new Song(title, artist, album, albumCover, path);
				checkForEmptyValuesAndSetDefaults(song);
				songs.add(song);
			} catch (CannotReadException | IOException | TagException | ReadOnlyFileException
					| InvalidAudioFrameException e) {
				e.printStackTrace();
			}
		}
	}

	public void sort() {
		Collections.sort(songs);
	}

	private void checkForEmptyValuesAndSetDefaults(Song song) {
		if(song.getTitle() == "") {
			String path = song.getPath().toString();
			song.setTitle(path);
		}
		if(song.getArtist() == "") {
			song.setArtist("Unknown Arist");
		}
		if(song.getAlbum() == "") {
			song.setAlbum("Unknown Album");
		}
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

	public String[] getSongTitles() {
		String[] stringArray = new String[songs.size()];
		for(int i = 0; i < songs.size(); i++) {
			stringArray[i] = songs.get(i).getTitle();
		}
		return stringArray;
	}

}
