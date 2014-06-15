package com.saulo.faltaquanto.model;

public abstract class Extra {

	public enum Type {
		WorkList, Presence,
	}

	protected String name;
	protected double value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public abstract Type getType();
}
