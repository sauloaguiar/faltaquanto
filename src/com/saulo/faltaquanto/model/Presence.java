package com.saulo.faltaquanto.model;

public class Presence extends Extra {

	public Presence() {
		this.name = "Presence";
		this.value = 1.0;
	}
	
	@Override
	public Type getType() {
		return Type.Presence;
	}

}
