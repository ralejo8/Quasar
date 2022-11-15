package com.meli.Quasar.Modelo;

public class Carrier extends Spaceship {
	private String message;

    public Carrier(Position position, String message){
        this.setPosition(position);
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
