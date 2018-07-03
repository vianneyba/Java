package com.vianney;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class Swing extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFileChooser selection = new JFileChooser();
	private JToolBar boutons = new JToolBar("Choix du fichier texte");
	private JTextArea editeur = new JTextArea(30, 60);
	private JLabel nomFichier = new JLabel();
	private JLabel lbEtat= new JLabel("", JLabel.CENTER);
	private JButton btnSave = new JButton("Enregistrer");
	private JButton btnDelete = new JButton("Effacer");
	private JButton btnSaveAs= new JButton("Enr. Sous");
		
	private File fichier;

	
	public Swing() {
		super("Editeur de fichiers");		
		add(boutons, BorderLayout.NORTH);
		add(new JScrollPane(editeur));
		editeur.setBackground(Color.YELLOW);
		boutons.add(new AbstractAction("Sélection du fichier") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				if (selection.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					addBtnSave();
					addBtnDelete();
					fichier = selection.getSelectedFile();
					nomFichier.setText(fichier.getPath());
					try {
						
						BufferedReader in = new BufferedReader(new FileReader(fichier));
						String buffer= "";
						String ligne;
//						int i=0;
						while((ligne= in.readLine()) != null) {
							buffer += ligne +"\n";
//							i++;
						}
						editeur.setText(buffer);
						in.close();
						
						
					} catch (FileNotFoundException ex) {
						nomFichier.setText("Fichier non trouvé");
					} catch (IOException ex) {
						nomFichier.setText("Problème de lecture dans le fichier");
					}
				}
			}
		});
		
		boutons.addSeparator();
		boutons.add(nomFichier);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);			
	}
	
	public void addBtnDelete() {
		btnDelete.addActionListener(new btnDeleteListener());
		btnDelete.setMnemonic(KeyEvent.VK_DELETE);
		
		boutons.addSeparator();
		boutons.add(btnDelete, boutons);
	}

	public void addBtnSave() {
		btnSave.addActionListener(new btnSaveListener());
		btnSave.setMnemonic(KeyEvent.VK_S);
		btnSaveAs.addActionListener(new btnSaveAsListner());
		lbEtat.setForeground(Color.RED);
		lbEtat.setHorizontalAlignment(SwingConstants.CENTER);
		
		boutons.addSeparator();
		boutons.add(btnSave, boutons);
		boutons.addSeparator();
		boutons.add(btnSaveAs, boutons);
		boutons.addSeparator();
		boutons.add(lbEtat);
	}
	
	class btnDeleteListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			fichier.delete();
			majLabel(lbEtat, "Fichier Effacer");
			nomFichier.setText("");
			editeur.setText("");
			boutons.remove(btnSave);
			boutons.remove(btnDelete);
		}
	}
	
	class btnSaveAsListner implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (selection.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				fichier= selection.getSelectedFile();
				saveText(fichier);
				majLabel(lbEtat, "Fichier Enregistrer");
			}
		}
	}
	
	class btnSaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
			saveText(fichier);
			majLabel(lbEtat, "Fichier Enregistrer");
		}
	}
	
	private void majLabel(JLabel label, String texte) {
		lbEtat.setText(texte);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			  public void run() {
				  label.setText("");
			  }
			}, 2*60*15);
	}
	
	private void saveText(File fichier) {
		try {
			Writer myFileWrite= new FileWriter(fichier);
			BufferedWriter bw = new BufferedWriter(myFileWrite);
			PrintWriter out = new PrintWriter(bw);
			
			out.println(editeur.getText());
			
			out.close();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Swing();
	}
}
