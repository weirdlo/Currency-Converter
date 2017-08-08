package com.green.converterphaseVI;
/*
 * To display all of the GUIs in one big GUI
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DisplayGUI extends JPanel{
	private static final UserOptionsGUI uo = new UserOptionsGUI();
	private static final ModificationsGUI m = new ModificationsGUI();
	private static final CurrencyConverterGUI cc = new CurrencyConverterGUI();
	private static DisplayGUI instance;
	
	private DisplayGUI(){
		JPanel leftSide = new JPanel(new GridLayout(2,1));
		JPanel rightSide = new JPanel(new GridLayout(1,1));
		add(leftSide);
		add(rightSide);
		
		leftSide.add(uo);
		leftSide.add(m);
		rightSide.add(cc);
		
		m.currencyCodeInput.setEditable(false);
		m.currencyRateInput.setEditable(false);
		cc.currencyRateInput.setEditable(false);
	}//end
	
	public CurrencyConverterGUI getCurrencyConverterGUI(){
		return this.cc;
	}
	
	public ModificationsGUI getModificationsGUI(){
		return m;
	}
	
	public UserOptionsGUI getUserOptionsGUI(){
		return uo;
	}
	
	public static DisplayGUI getInstance(){
		if (instance == null){
			instance = new DisplayGUI();
		}
		return instance;
	}

	public static void main(String[] args){
		UpdateCurrencyLibrary.updateCurrencies();
		DisplayGUI show = getInstance();
		
		JFrame frame = new JFrame("Currency Conversion");
		frame.setLayout(new BorderLayout());
		frame.getContentPane().add(show);
		frame.pack();
		frame.setSize(1100, 350);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
	}//end
}//end of class
