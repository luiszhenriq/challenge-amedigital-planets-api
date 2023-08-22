package br.com.luis.desafioamedigitalstarwars.model;

import br.com.luis.desafioamedigitalstarwars.domain.PlanetDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "planets")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String climate;

    private String ground;

    public Planet(PlanetDTO planet) {
        this.name = planet.name();
        this.climate = planet.climate();
        this.ground = planet.ground();
    }
}
