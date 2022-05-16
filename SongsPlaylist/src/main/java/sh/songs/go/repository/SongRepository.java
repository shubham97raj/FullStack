package sh.songs.go.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sh.songs.go.entity.Song;

@Repository
public interface SongRepository extends JpaRepository<Song,Long>{

}
