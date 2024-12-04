package com.m4ricu.single.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.m4ricu.single.model.Lyrics;
import com.m4ricu.single.repository.LyricsRepository;

@ExtendWith(MockitoExtension.class)
class LyricsServiceTest {

    @Mock
    private LyricsRepository lyricsRepository;

    @InjectMocks
    private LyricsService lyricsService;

    @Test
    void testGetLyricsById() {
        Long artistId = 1L;
        Lyrics lyrics = new Lyrics();
        when(lyricsRepository.findRandomLyricByArtistId(artistId)).thenReturn(Optional.of(lyrics));
        Optional<Lyrics> result = lyricsService.getLyricsById(artistId);
        assertEquals(Optional.of(lyrics), result);
    }
}
