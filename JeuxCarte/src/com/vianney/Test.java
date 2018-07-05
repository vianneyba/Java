package com.vianney;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Test {

	public static void main(String[] args) {
			
//		Paquet paquet= new Paquet();
//
//		Map<String, Main> joueurs= new LinkedHashMap<>();
//		joueurs.put("vianney", new Main());
//		joueurs.put("marc", new Main());
//		joueurs.put("paul", new Main());
//
//		for(Entry<String, Main> entry : joueurs.entrySet()) {
//			String joueur = entry.getKey();
//			Main main = entry.getValue();
//			
//			main.add(paquet.distribution(7));
//			
//			System.out.println("====="+ joueur +"=====");
//			System.out.println(main.toString());
//		}
//		
//		System.out.println(paquet.toString());
		
		Carte c1 = new Carte(5, Carte.CARREAU);
		System.out.println(c1.getI());
		Carte c2 = new Carte(6, Carte.CARREAU);
		Carte c3 = new Carte(6, Carte.CARREAU);
		Carte c4 = new Carte(6, Carte.CARREAU);
		System.out.println(c1.getI());
	}
}
