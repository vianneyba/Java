package com.vianney;

import java.util.ArrayList;
import java.util.Random;

public class Paquet {
	public static final String PIQUE = "pique";
	public static final String TREFLE = "trefle";
	public static final String COEUR = "coeur";
	public static final String CARREAU = "carreau";
	public static final String[] couleurs = { PIQUE, TREFLE, COEUR, CARREAU };
	private ArrayList<Carte> paquet;
	
	public Paquet() {
		paquet= new ArrayList<Carte>();
		creePaquet();
		random();
	}
	
	private void creePaquet() {
		for (int i = 1; i < 14; i++) {
			for (int j = 0; j < 4; j++) {
					paquet.add(new Carte(i, couleurs[j]));		
			}
		}
	}

	@Override
	public String toString() {
		String message = "===== Contenu du paquet =====\n";
		for (Carte carte : paquet) {
			message+= carte.getValeur() + carte.getCouleur() +"\n";
		}
		return message;
	}
	
	public ArrayList<Carte> distribution(int nbr) {
		ArrayList<Carte> liste= new ArrayList<>();
		for (int i = 0; i < nbr; i++) {
			int j= size()-1;
			liste.add(paquet.get(j));
			paquet.remove(j);
		}

		return liste;
	}
	
	private void random() {
		for (int i = 0; i < 3000; i++) {
			Random rn = new Random();
			int j = rn.nextInt(paquet.size());			
			paquet.add(paquet.get(j));
			paquet.remove(j);
		}
	}
	
	private int size() {
		return paquet.size();
	}
}
