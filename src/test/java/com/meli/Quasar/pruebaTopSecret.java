package com.meli.Quasar;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.meli.Quasar.Modelo.Satellite;
import com.meli.Quasar.Modelo.SatelliteWrapper;
import com.meli.Quasar.Modelo.Spaceship;
import com.meli.Quasar.Servicio.ComunicacionServicio;
@RunWith(MockitoJUnitRunner.class)
public class pruebaTopSecret {

	@InjectMocks
    ComunicacionServicio comunicacionServicio;;
@Test
public	void topSecret()  {
	//datos prueba
   SatelliteWrapper objSatelliteWrapper=new SatelliteWrapper();
	List<String> arrmg=Arrays.asList("este", "", "","mensaje","");
	SatelliteWrapper satelliteWrapper=new SatelliteWrapper();
	List<Satellite> arrSatellite=new ArrayList<>();
	Satellite objSatellite=new Satellite();
	objSatellite.setName("kenobi");
	objSatellite.setDistance(100.0);
	objSatellite.setMessage(arrmg);
	arrSatellite.add(objSatellite);
	
	arrmg=new ArrayList<String>();
	arrmg=Arrays.asList("", "es", "","","secreto");
	objSatellite=new Satellite();
	objSatellite.setName("skywalker");
	objSatellite.setDistance(115.5);
	objSatellite.setMessage(arrmg);
	arrSatellite.add(objSatellite);
	
	arrmg=new ArrayList<String>();
	arrmg=Arrays.asList("este", "", "un","","");
	objSatellite=new Satellite();
	objSatellite.setName("sato");
	objSatellite.setDistance(142.7);
	objSatellite.setMessage(arrmg);
	arrSatellite.add(objSatellite);
	
	objSatelliteWrapper.setSatellites(arrSatellite);
	//esperado

	JSONObject obj = new JSONObject();
	JSONObject objPosition = new JSONObject();
	try {
		objPosition.put( "x", -58.315252587138595);
		objPosition.put( "y", -69.55141837312165);
		obj.put("position", objPosition);
		obj.put("message", "este es un mensaje secreto");
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	//ejecucion y obtenido
	Spaceship objObtenido= comunicacionServicio.getUbicacion(objSatelliteWrapper);
	
	//comparar resultados
	assertEquals(objObtenido, objObtenido);
}


}
