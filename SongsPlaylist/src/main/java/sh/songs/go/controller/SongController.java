package sh.songs.go.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sh.songs.go.entity.Song;
import sh.songs.go.exception.ResourceNotFoundException;
import sh.songs.go.repository.SongRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class SongController {
	
	
	@Autowired
	private SongRepository repo;
	

	@GetMapping("/songs")
	public List<Song> getAllSongs() {
		return repo.findAll();
	}

	
	@GetMapping("/songs/{id}")
	public ResponseEntity<Song> getSongById(@PathVariable(value = "id") Long songId)
			throws ResourceNotFoundException {
		Song song = repo.findById(songId)
				.orElseThrow(() -> new ResourceNotFoundException("Song not found for this id :: " + songId));
		return ResponseEntity.ok().body(song);
	}
	
	/*
	 * @GetMapping("/songs/{songName}") public ResponseEntity<Song>
	 * getSongBySongName(@PathVariable(value = "songName") String songName){
	 * ResponseEntity<?> response=new
	 * ResponseEntity<>(getErrorMessage,HttpStatus.FOUND); Song song =
	 * service .getSongBySongName(songName); if(song!=null)
	 * response=ResponseEntity.ok("Song name is found :"+ song);
	 * 
	 * return response; }
	 */

	@PostMapping("/songs")
	public Song createSong(@RequestBody Song song) {
		return repo.save(song);
	}
	
	
	@PutMapping("/songs/{id}")
	public ResponseEntity<Song> updateSong(@PathVariable(value = "id") Long songId,
			 @RequestBody Song songDetails) throws ResourceNotFoundException {
		Song song = repo.findById(songId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + songId));

		song.setMoodSong(songDetails.getMoodSong());
		song.setSingerName(songDetails.getSingerName());
		song.setSongName(songDetails.getSongName());
		final Song updatedSong = repo.save(song);
		return ResponseEntity.ok(updatedSong);
	}

	@DeleteMapping("/songs/{id}")
	public Map<String, Boolean> deleteSong(@PathVariable(value = "id") Long songId)
			throws ResourceNotFoundException {
		Song song = repo.findById(songId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + songId));

		repo.delete(song);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
