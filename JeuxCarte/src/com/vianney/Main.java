package com.vianney;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
	private HashSet<Carte> main;
	
	public Main() {
		main= new HashSet<Carte>();
	}
	
	public void add(Carte c) {
		main.add(c);
	}
	
	public void add(ArrayList<Carte> c) {
		main.addAll(c);
	}
	public void remove(Carte c) {
		main.remove(c);
	}

	@Override
	public String toString() {
		String message = "";
		for (Carte carte : main) {
			message+= carte.getValeur() + carte.getCouleur() +"\n";
		}
		return message;
	}
	public boolean contient(Carte c) {
		if (main.contains(c)) {
			System.out.println("contient");
			return true;
		} else {
			System.out.println("contient pas");
			return false;
		}
		
	}
	
	public int size() {
		return main.size();	
	}
}
