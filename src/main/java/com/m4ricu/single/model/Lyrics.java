package com.m4ricu.single.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "lyrics") // Certifique-se de que o nome da tabela está correto
public class Lyrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lyrics_id")
    private Long id;

    @Column(name = "lyrics")
    private String content;
    // Adicione o relacionamento com Artist

    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "artist_id")
    private Artist artist;
}
