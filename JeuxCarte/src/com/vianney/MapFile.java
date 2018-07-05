package com.vianney;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapFile {
	static int nbrline= 1;
	private Map<Integer, String> texte;
	private FileReader file;
	private Writer fileW;
	private String chemin;
	
	public MapFile(String uFile) throws IOException {
		chemin= uFile;
		texte = new LinkedHashMap<>();
		lire();
	}
		
	public void afficher() {
		System.out.printf("le fichier contient %d lignes\n", nbrline-1);
		for (Map.Entry<Integer, String> e : texte.entrySet()) {
			System.out.printf("ligne %3d %s\n", e.getKey(), e.getValue());
		}
	}
	
	public void lire() throws IOException {
		file = new FileReader(chemin);
		BufferedReader fReader = null;
		fReader = new BufferedReader(file);
		String line;
		try {
			while ((line = fReader.readLine()) != null) {
				texte.put(nbrline, line);
				nbrline++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fReader.close();
		}
	}
	
	public void addAtEnd(String line) throws IOException {    
		texte.put(nbrline, line);
		nbrline++;
	}
	
	public void save() throws FileNotFoundException {
		fileW= new PrintWriter(chemin);
		BufferedWriter bw = null;
		bw = new BufferedWriter(fileW);
		PrintWriter out = new PrintWriter(bw);
		
		for (Map.Entry<Integer, String> d : texte.entrySet()) {
			out.println(d.getValue());
		}
		out.close();
	}

	public void addByLine(String line, Integer nbre) throws IOException {
		Map<Integer, String> copy= new HashMap<>() ;
		
		if (nbre > texte.size())  {
			addAtEnd(line);
		} else {	
			for (Map.Entry<Integer, String> e : texte.entrySet()) {
//				System.out.printf("%d = %d = %d\n", e.getKey(), nbre, nbrline);
				
				if (e.getKey() < nbre) {
					copy.put(e.getKey(), e.getValue());
				} else if (e.getKey() == nbre) {
					copy.put(nbre, line);
					copy.put(e.getKey()+1, e.getValue());
					nbrline++;
				} else if (e.getKey() > nbre) {
					copy.put(e.getKey()+1, e.getValue());
				}
			}
			texte.clear();
			texte.putAll(copy);
		}
	}

	public void addByLineLinked(String line, Integer nbre) throws IOException {
		List <String> myList= new LinkedList<>(texte.values());
				
		if (nbre > texte.size())  {
			addAtEnd(line);
		} else {	
			for (Map.Entry<Integer, String> e : texte.entrySet()) {
				if (e.getKey() == nbre) {
					myList.add(e.getKey(), line);
					nbrline++;
				}
			}
			
			texte.clear();
			for (int i = 1; i < myList.size()+1; i++) {
				texte.put(i, myList.get(i-1));
			}
		}
	}
}