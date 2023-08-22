package br.com.luis.desafioamedigitalstarwars.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PlanetDTO(
        @NotBlank
        String name,
        @NotBlank
        String climate,
        @NotBlank
        String ground) {
}
