package com.meli.Quasar.Modelo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.mapping.Document;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "SatelliteRep")
public class SatelliteRep {
	private double distance;

    private String name;

    private List<String> message;

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public double getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public List<String> getMessage() {
        return message;
    }
}
