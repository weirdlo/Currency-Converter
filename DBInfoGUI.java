package com.green.converterphaseVI;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DBInfoGUI extends JPanel{
	static JTextArea information;
	
	public DBInfoGUI(){
		JPanel infoLayout = new JPanel(new GridLayout());
		add(infoLayout);
		
		information = new JTextArea("Database Information....");
		information.setPreferredSize(new Dimension(300, 300));
		information.setEditable(false);
		
		add(information);
		infoLayout.add(new JScrollPane(information));
	}//end
}//end of class
