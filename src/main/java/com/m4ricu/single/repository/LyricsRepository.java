
package com.m4ricu.single.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.m4ricu.single.model.Lyrics;

public interface LyricsRepository extends JpaRepository<Lyrics, Long> {
    @Query(value = "SELECT * FROM lyrics WHERE artist_id = :artistId ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Lyrics> findRandomLyricByArtistId(@Param("artistId") Long artistId);
}
