package com.meli.Quasar.Repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.meli.Quasar.Modelo.Satellite;
import com.meli.Quasar.Modelo.SatelliteRep;


public interface SatelliteRepositorio extends MongoRepository<SatelliteRep,Integer>{
	 public SatelliteRep findByName(String name);
}
