package com.vianney;

public class Carte {
	public static final String PIQUE = "pique";
	public static final String TREFLE = "trefle";
	public static final String COEUR = "coeur";
	public static final String CARREAU = "carreau";
	public static final String[] couleurs = { PIQUE, TREFLE, COEUR, CARREAU };
	private int valeur;
	private String couleur;
	
	static int i;

	public Carte(int valeur, String couleur) {
		i++;
		this.valeur = valeur;
		this.couleur = couleur;
	}

	public int getValeur() {
		return valeur;
	}

	public String getCouleur() {
		return couleur;
	}

	@Override
	public String toString() {
		return "" + valeur + " de " + couleur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
		result = prime * result + valeur;
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
		Carte other = (Carte) obj;
		if (couleur == null) {
			if (other.couleur != null)
				return false;
		} else if (!couleur.equals(other.couleur))
			return false;
		if (valeur != other.valeur)
			return false;
		return true;
	}
	
	public int getI() {
		return i;
	}
}