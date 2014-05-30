package com.saulo.faltaquanto.model;

public class Grade {

	private String name;
	private double value;
	private double weight;

	public Grade() {
	}

	public Grade(String name, double value) {
		this.name = name;
		this.value = value;
		this.weight = 1.0;
	}

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

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}