package br.com.luis.desafioamedigitalstarwars.repositories;

import br.com.luis.desafioamedigitalstarwars.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
    List<Planet> findByNameContainingIgnoreCase(String name);
}
