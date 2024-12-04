package com.m4ricu.single.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GenreTest {

    @Test
    void testGenre() {
        Genre genre = new Genre();
        genre.setId(1L);
        genre.setName("Rock");

        assertEquals(1L, genre.getId());
        assertEquals("Rock", genre.getName());
    }
}
