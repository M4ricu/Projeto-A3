package com.m4ricu.single.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class ArtistTest {

    @Test
    void testArtist() {
        Artist artist = new Artist();
        artist.setArtistId(1L);
        artist.setName("Nome do Artista");
        artist.setAge(30);
        artist.setGender("Masculino");
        artist.setIsAlive(true);
        artist.setImgUrl("url_da_imagem");
        artist.setDecade(2000);
        artist.setWonGrammy(false);

        Set<Genre> genres = new HashSet<>();
        Genre genre1 = new Genre();
        genre1.setId(1L);
        genre1.setName("Rock");

        Genre genre2 = new Genre();
        genre2.setId(2L);
        genre2.setName("Pop");

        genres.add(genre1);
        genres.add(genre2);

        artist.setGenres(genres);

        assertEquals(1L, artist.getArtistId());
        assertEquals("Nome do Artista", artist.getName());
        assertEquals(30, artist.getAge());
        assertEquals("Masculino", artist.getGender());
        assertTrue(artist.getIsAlive());
        assertEquals("url_da_imagem", artist.getImgUrl());
        assertEquals(2000, artist.getDecade());
        assertFalse(artist.getWonGrammy());
        assertEquals(2, artist.getGenres().size());

    }
}
