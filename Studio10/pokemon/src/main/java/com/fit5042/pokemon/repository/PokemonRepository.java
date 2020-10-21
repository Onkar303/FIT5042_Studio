package com.fit5042.pokemon.repository;


import com.fit5042.pokemon.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PokemonRepository extends JpaRepository<Pokemon, Long> { }