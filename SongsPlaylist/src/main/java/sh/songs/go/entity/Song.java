package sh.songs.go.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="songs")
public class Song {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	private String songName;
	private String singerName;
	private String moodSong;
	
	
	public Song() {
		super();
		
	}


	public Song(String songName, String singerName, String moodSong) {
		this.songName = songName;
		this.singerName = singerName;
		this.moodSong = moodSong;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "song_name", nullable = false)
	public String getSongName() {
		return songName;
	}


	public void setSongName(String songName) {
		this.songName = songName;
	}

	@Column(name = "singer_name", nullable = false)
	public String getSingerName() {
		return singerName;
	}


	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	@Column(name = "mood_song", nullable = false)
	public String getMoodSong() {
		return moodSong;
	}


	public void setMoodSong(String moodSong) {
		this.moodSong = moodSong;
	}
	
	

}
