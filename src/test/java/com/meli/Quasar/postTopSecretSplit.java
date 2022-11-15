package com.meli.Quasar;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.meli.Quasar.Modelo.Satellite;
import com.meli.Quasar.Servicio.ComunicacionServicio;
@RunWith(MockitoJUnitRunner.class)
public class postTopSecretSplit {
	@InjectMocks
    ComunicacionServicio comunicacionServicio;;
	@Test
	public void test() {
		//carga datos
		String nombre="kenobi";
		List<String> arrmg=Arrays.asList("este", "", "","mensaje","");
		Satellite objsatellite=new Satellite();
		objsatellite.setDistance(142.7);
		objsatellite.setMessage(arrmg);
		boolean rest=comunicacionServicio.getUbicacionobj(objsatellite, nombre);
		assertTrue(rest);
	}

}
