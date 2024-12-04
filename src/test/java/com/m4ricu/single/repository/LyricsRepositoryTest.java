package com.m4ricu.single.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.m4ricu.single.model.Lyrics;

@ExtendWith(MockitoExtension.class)
class LyricsRepositoryTest {

    @Mock
    private LyricsRepository lyricsRepository;

    @Test
    void testFindRandomLyricByArtistId() {
        Long artistId = 1L;
        when(lyricsRepository.findRandomLyricByArtistId(artistId)).thenReturn(Optional.of(new Lyrics()));
        Optional<Lyrics> randomLyric = lyricsRepository.findRandomLyricByArtistId(artistId);
        assertTrue(randomLyric.isPresent());
    }
}
