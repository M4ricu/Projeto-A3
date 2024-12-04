package com.m4ricu.single.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.m4ricu.single.model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    @Query(value = "SELECT * FROM artist ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Artist> findRandomArtist();

    @Query("SELECT a FROM Artist a") // JPQL query to select all artists
    List<Artist> findAllArtists();
}
