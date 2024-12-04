package com.m4ricu.single.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.m4ricu.single.model.Artist;

@ExtendWith(MockitoExtension.class)
class ArtistRepositoryTest {

    @Mock
    private ArtistRepository artistRepository;

    @Test
    void testFindRandomArtist() {
        when(artistRepository.findRandomArtist()).thenReturn(Optional.of(new Artist()));
        Optional<Artist> randomArtist = artistRepository.findRandomArtist();
        assertTrue(randomArtist.isPresent());
    }

    @Test
    void testFindAllArtists() {
        when(artistRepository.findAllArtists()).thenReturn(List.of(new Artist(), new Artist()));
        List<Artist> artists = artistRepository.findAllArtists();
        assertEquals(2, artists.size());
    }
}
