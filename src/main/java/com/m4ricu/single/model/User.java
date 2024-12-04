package com.m4ricu.single.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * Entidade representando um usuário.
 */
@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @Column(unique = true, nullable = false)
    @NotBlank(message = "CPF não pode estar em branco")
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$", message = "Formato de CPF inválido")
    private String cpf;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

}