package com.meli.Quasar.Servicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import com.meli.Quasar.Modelo.Carrier;
import com.meli.Quasar.Modelo.Position;
import com.meli.Quasar.Modelo.Satellite;
import com.meli.Quasar.Modelo.SatelliteRep;
import com.meli.Quasar.Modelo.SatelliteWrapper;
import com.meli.Quasar.Modelo.Spaceship;
import com.meli.Quasar.Repositorio.SatelliteRepositorio;
import com.meli.Quasar.error.InvalidDataException;

@Service
public class ComunicacionServicio {
	 @Autowired
	 MessageServicio messageServicio;
	 @Autowired
	    private Environment environment;
	 @Autowired
	 LocationServicio locationServicio;
	 
	 @Autowired
	 SatelliteRepositorio satelliteRepositorio;
	  public Spaceship getUbicacion(SatelliteWrapper satelliteWrapper)  {

	       
	        String mg="";
	        if(satelliteWrapper.getMessages().size() < 2)
	        	throw new InvalidDataException("Nùmero de mensajes insuficientes");
	        String message = messageServicio.getMessage(satelliteWrapper.getMessages());

	        uploadPositions(satelliteWrapper);
	        if( (satelliteWrapper.getPositions().length < 2) || (satelliteWrapper.getDistances().length < 2) )
	            throw new InvalidDataException("Nùmero posicion o distancias insuficientes");
	        double [] points = locationServicio.getLocation(satelliteWrapper.getPositions(), satelliteWrapper.getDistances());
	        Position position = new Position(points);

	        return new Carrier(position, message);
	    }
	  
	  public void uploadPositions(SatelliteWrapper satelliteWrapper){

	        if(satelliteWrapper.getPositions()[0] == null) {
	            int numberSat = Integer.parseInt(environment.getProperty("satellites.numbers"));
	            double[][] pointsList = new double[numberSat][];
	            String[] satellitePos;
	            for (int i = 0; i < satelliteWrapper.getSatellites().size(); i++) {
	                satellitePos = environment.getProperty("satellites." + i + ".position").split(",");
	                pointsList[i] = Arrays.stream(satellitePos)
	                        .map(Double::valueOf)
	                        .mapToDouble(Double::doubleValue)
	                        .toArray();
	            }
	            satelliteWrapper.setPositions(pointsList);
	        }
	    }
	  
	  public boolean getUbicacionobj(Satellite satellite,String nombre)  {
		  satelliteRepositorio.insert(SatelliteRep.builder().message(satellite.getMessage())
				  .distance(satellite.getDistance())
				  .name(nombre).build());
		return true;
	    }
	  
	  public Spaceship getUbicacionBD()  {
		  RequestEntity requestEntity;
		  List<SatelliteRep>arrSatelliteRep=satelliteRepositorio.findAll();
		  List<Satellite> arrsatellites=new ArrayList<>(); 
		  for(int i=0;i<arrSatelliteRep.size();i++)
		  {
			  Satellite objSatellite=new Satellite();
			  objSatellite.setDistance(arrSatelliteRep.get(i).getDistance());
			  objSatellite.setMessage(arrSatelliteRep.get(i).getMessage());
			  objSatellite.setName(arrSatelliteRep.get(i).getName());
			  arrsatellites.add(objSatellite);
		  }
	        SatelliteWrapper satelliteWrapper=new SatelliteWrapper();
	        satelliteWrapper.setSatellites(arrsatellites);
	      
	        String mg="";
	        if(satelliteWrapper.getMessages().size() < 2)
	            throw new InvalidDataException("Nùmero de mensajes insuficientes");
	        String message = messageServicio.getMessage(satelliteWrapper.getMessages());

	        uploadPositions(satelliteWrapper);
	        if( (satelliteWrapper.getPositions().length < 2) || (satelliteWrapper.getDistances().length < 2) )
	            throw new InvalidDataException("Nùmero posicion o distancias insuficientes");
	        double [] points = locationServicio.getLocation(satelliteWrapper.getPositions(), satelliteWrapper.getDistances());
	        Position position = new Position(points);

	        return new Carrier(position, message);
	    }
}
