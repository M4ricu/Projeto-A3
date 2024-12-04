package com.m4ricu.single.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.m4ricu.single.model.Artist;
import com.m4ricu.single.model.Login;
import com.m4ricu.single.model.Lyrics;
import com.m4ricu.single.model.User;
import com.m4ricu.single.service.ArtistService;
import com.m4ricu.single.service.LyricsService;
import com.m4ricu.single.service.UserService;

@CrossOrigin(maxAge = 3600)
@RestController
public class SingleAPI {
    @Autowired
    private ArtistService artistService;
    @Autowired
    private LyricsService lyricsService;
    @Autowired
    private UserService userService;

    public SingleAPI(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/randomartist")
    public ResponseEntity<Artist> getArtist() {
        Artist artist = artistService.getRandomArtist();
        if (artist != null) {
            return ResponseEntity.ok(artist); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @CrossOrigin
    @GetMapping("/api/artists")
    public ResponseEntity<List<Artist>> getAllArtists() {
        List<Artist> artists = artistService.getAllArtist();
        if (artists != null) {
            return ResponseEntity.ok(artists); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @GetMapping("/api/artist/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long id) {
        Artist artist = artistService.getArtistById(id);
        if (artist != null) {
            return ResponseEntity.ok(artist); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @GetMapping("/api/lyrics/{artistId}")
    public ResponseEntity<Optional<Lyrics>> getLyricByid(@PathVariable Long artistId) {
        Optional<Lyrics> lyric = lyricsService.getLyricsById(artistId);
        if (lyric != null) {
            return ResponseEntity.ok(lyric); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping("/api/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        if (registeredUser != null) {
            return ResponseEntity.ok(registeredUser);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou CPF já registrados.");
    }

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody Login user) {
        User loggedInUser = userService.loginUser(user);
        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha incorretos.");
    }

}
