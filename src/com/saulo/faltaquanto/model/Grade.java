package com.saulo.faltaquanto.model;

import java.util.ArrayList;
import java.util.List;

public class Grade {

	private String name;
	private double value;
	private double weight;
	private List<Extra> extras;

	public Grade(String name, Double value, Double weight) {
		this.name = name;
		this.value = value;
		this.weight = weight;
		this.extras = new ArrayList<Extra>();
	}

	public Grade(String name, double value) {
		this.name = name;
		this.value = value;
		this.weight = 1.0;
		this.extras = new ArrayList<Extra>();
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
	
	public void addExtra(Extra extra){
		this.extras.add(extra);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grade other = (Grade) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public boolean hasPresence() {
		return this.extras.size() > 0;
	}
}
