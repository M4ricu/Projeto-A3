package com.m4ricu.single.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m4ricu.single.model.Artist;
import com.m4ricu.single.repository.ArtistRepository;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public Artist getRandomArtist() {

        Optional<Artist> optionalArtist = artistRepository.findRandomArtist();
        Artist artist = optionalArtist.get();
        return artist;

    }

    public List<Artist> getAllArtist() {

        List<Artist> artists = artistRepository.findAllArtists();
        return artists;

    }

    public Artist getArtistById(Long id) {

        Optional<Artist> optionalArtist = artistRepository.findById(id);
        Artist artist = optionalArtist.get();
        return artist;

    }
}
