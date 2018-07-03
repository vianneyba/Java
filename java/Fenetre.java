package com.vianney;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Fenetre extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public Fenetre() {
		super("Mon Editeur de texte");
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setJMenuBar(foncMyMenu());
		this.setVisible(true);
	}
	
	public JMenuBar foncMyMenu () {
		JMenuBar myMenu = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem save = new JMenuItem("Save");
		save.setAccelerator(KeyStroke.getKeyStroke('s'));
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionSave();
				
			}
		});
		JMenuItem saveAs = new JMenuItem("Save As");		
		saveAs.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSaveAs();
				
			}
		});
		JMenuItem exit = new JMenuItem("Quit");
		exit.setAccelerator(KeyStroke.getKeyStroke('q'));
		exit.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionExit();
				
			}
		});
		
		JMenu edit = new JMenu("Edit");
		JMenuItem copy = new JMenuItem("Copy");
		
		file.setMnemonic('A');
		myMenu.add(file);
		edit.setMnemonic('E');
		myMenu.add(edit);
		
		file.add(save);
		file.add(saveAs);
		file.add(exit);
		
		edit.add(copy);
		
		return myMenu;
	}
	
	private void actionSave() {
		System.out.println("Je clique dans le menu Enregistrer");
	}
	
	private void actionSaveAs() {
		System.out.println("Je clique dans le menu Enregistrer sous");
	}
	
	private void actionExit() {
		System.exit(0);
	}
}
