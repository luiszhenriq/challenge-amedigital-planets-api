package br.com.luis.desafioamedigitalstarwars.domain;

import br.com.luis.desafioamedigitalstarwars.model.Planet;

public record PlanetListDTO(Long id, String name, String climate, String ground) {

    public PlanetListDTO(Planet planet) {
        this(planet.getId(), planet.getName(), planet.getClimate(), planet.getGround());
    }


}
