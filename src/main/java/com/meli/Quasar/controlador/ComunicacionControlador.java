package com.meli.Quasar.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meli.Quasar.Modelo.Satellite;
import com.meli.Quasar.Modelo.SatelliteWrapper;
import com.meli.Quasar.Repositorio.SatelliteRepositorio;
import com.meli.Quasar.Servicio.ComunicacionServicio;
import com.meli.Quasar.error.InvalidDataException;

@RestController

public class ComunicacionControlador {
	 @Autowired
	    private ComunicacionServicio comunicacionServicio;
	 @Autowired
	 SatelliteRepositorio satelliteRepositorio;
	
	@PostMapping(value= "/topSecret",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity topSecret(RequestEntity<SatelliteWrapper> requestEntity){
		
	
try {
	 SatelliteWrapper satelliteWrapper = (SatelliteWrapper)requestEntity.getBody();
	 return ResponseEntity.status(HttpStatus.OK).body(comunicacionServicio.getUbicacion(satelliteWrapper));

} catch (InvalidDataException e) {
	
	throw new InvalidDataException("Datos invalidos-"+e.getMessage());
} 

    }
	@PostMapping(value= "topsecret_split/{name}",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity postTopSecretSplit(@PathVariable String name, @RequestBody Satellite Satellite){
		
		comunicacionServicio.getUbicacionobj(Satellite,name);
		
		return ResponseEntity.ok().build(); 
	

		

    }
   

	 
	@GetMapping(value = "topsecret_split", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTopSecretSplit(){
		
		 return ResponseEntity.ok(comunicacionServicio.getUbicacionBD());
	

		

    }
}
