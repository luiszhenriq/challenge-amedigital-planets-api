package br.com.luis.desafioamedigitalstarwars.controller;


import br.com.luis.desafioamedigitalstarwars.domain.PlanetDTO;
import br.com.luis.desafioamedigitalstarwars.domain.PlanetListDTO;
import br.com.luis.desafioamedigitalstarwars.model.Planet;
import br.com.luis.desafioamedigitalstarwars.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planet")
public class PlanetController {
    @Autowired
    private PlanetRepository repository;

    @PostMapping
    public void addPlanet(@RequestBody PlanetDTO planet) {
        repository.save(new Planet(planet));
    }

    @GetMapping
    public List<PlanetListDTO> getAllPlanets() {
        return repository.findAll().stream().map(PlanetListDTO::new).toList();
    }

    @GetMapping("/{id}")
    public Optional<Planet> getPlanetById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @GetMapping("name")
    public List<PlanetListDTO> getPlanetsByName(@RequestParam String name) {
        List<Planet> planetsWithName = repository.findByNameContainingIgnoreCase(name);
        return planetsWithName.stream().map(PlanetListDTO::new).toList();
    }
    @DeleteMapping("/{id}")
    public void deletePlanet(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
