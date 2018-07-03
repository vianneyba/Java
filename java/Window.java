package com.vianney;

import javax.swing.JFrame;

public class Window {
 public Window() {
	 JFrame fenetre = new JFrame();
	fenetre.setTitle("Ma première fenêtre");
	fenetre.setSize(400, 100);
	fenetre.setLocationRelativeTo(null);
	fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	fenetre.setVisible(true);
 }
}
