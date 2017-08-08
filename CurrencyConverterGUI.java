package com.green.converterphaseVI;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CurrencyConverterGUI extends JPanel{
	static JComboBox<String> selectFromCurrency, selectToCurrency;
	String[] selectFrom = new String[CurrencyLibrary.getFromCurrencies().size()];
	String[] selectTo = new String[CurrencyLibrary.getToCurrencies().size()];
	static JTextField currencyRateInput, convertedCurrencyOutput;
	private static String rateInput;
	CurrencyLibrary library = new CurrencyLibrary();
	ValidatingInputs vi = new ValidatingInputs();
	
	public CurrencyConverterGUI(){
    	JPanel panelSections = new JPanel(new GridLayout(3,1,3,10));
    	JPanel inputSection = new JPanel(new GridLayout(3,2,3,4));
    	JPanel outputSection = new JPanel(new GridLayout(1,1));
    	JPanel buttonSection = new JPanel(new GridLayout(1,2,25,10));
    	add(panelSections);
    	add(inputSection);
    	add(outputSection);
    	add(buttonSection);
    	
    	JLabel selectFromInstructions = new JLabel("Select the currency you want to convert from: ");
    	selectFrom = CurrencyLibrary.getFromCurrencies().toArray(selectFrom);
    	selectFromCurrency = new JComboBox<String>(selectFrom);
    	inputSection.add(selectFromInstructions);	inputSection.add(selectFromCurrency);
    	
    	JLabel inputInstructions  = new JLabel("Enter amount you want to convert:                          $");
    	currencyRateInput = new JTextField();
    	inputSection.add(inputInstructions);	inputSection.add(currencyRateInput);
    	
    	JLabel selectToInstructions =  new JLabel("Select the currency you want to convert to:");
    	selectTo = CurrencyLibrary.getToCurrencies().toArray(selectTo);
    	selectToCurrency = new JComboBox<String>(selectTo);
    	inputSection.add(selectToInstructions); 	inputSection.add(selectToCurrency);
    	
    	convertedCurrencyOutput = new JTextField();
    	convertedCurrencyOutput.setEditable(false);
    	outputSection.add(convertedCurrencyOutput);
    	
    	JButton convertCurrency = new JButton("Convert Currency");
    	convertCurrency.addActionListener(new ActionListener()
        {
    		public void actionPerformed(ActionEvent e)
            {
        	   rateInput = currencyRateInput.getText();
        	   vi.checkCurrencyRate(rateInput);
        	   ConvertCurrencies cc = new ConvertCurrencies();
        	   cc.convertCurrency(vi);
        	   convertedCurrencyOutput.setText(cc.displayOutput);
        	   vi.setCurrencyRate(0);
            }
        });
    	
    	JButton sweep = new JButton("Clear Currencies");
    	sweep.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                currencyRateInput.setText(null);
                convertedCurrencyOutput.setText(null);
                ModificationsGUI.currencyCodeInput.setText(null);
                ModificationsGUI.currencyRateInput.setText(null);
            }
        });
    	buttonSection.add(sweep);	buttonSection.add(convertCurrency); 
    	
    	panelSections.add(inputSection);
    	panelSections.add(outputSection);
    	panelSections.add(buttonSection);
    }//end
}//end of class
