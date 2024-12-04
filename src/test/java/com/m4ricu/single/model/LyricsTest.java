package com.m4ricu.single.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LyricsTest {

    @Test
    void testLyrics() {
        Lyrics lyrics = new Lyrics();
        lyrics.setId(1L);
        lyrics.setContent("Conteúdo da letra");

        Artist artist = new Artist();
        artist.setArtistId(1L);
        artist.setName("Nome do Artista");
        lyrics.setArtist(artist);

        assertEquals(1L, lyrics.getId());
        assertEquals("Conteúdo da letra", lyrics.getContent());
        assertEquals(1L, lyrics.getArtist().getArtistId());
        assertEquals("Nome do Artista", lyrics.getArtist().getName());

    }
}
