package com.green.converterphaseVI;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModificationsGUI extends JPanel{
	static JTextField currencyCodeInput, currencyRateInput;
	private static String codeInput, rateInput;
	ValidatingInputs vi = new ValidatingInputs();
	ModifyCurrencies m = new ModifyCurrencies();
	
	public ModificationsGUI(){
		JPanel panelSections = new JPanel(new GridLayout(2,1));
		JPanel inputSection = new JPanel(new GridLayout(2,2));
		JPanel commitSection = new JPanel(new GridLayout(1,1));
		add(panelSections);
		add(inputSection);
		add(commitSection);
		
		JLabel enterCurrencyCode = new JLabel("Enter the currency code: ");
		currencyCodeInput = new JTextField();
		inputSection.add(enterCurrencyCode);	inputSection.add(currencyCodeInput);
		
		JLabel enterCurrencyRate = new JLabel("Enter the new currency rate: ");
		currencyRateInput = new JTextField();
		inputSection.add(enterCurrencyRate);	inputSection.add(currencyRateInput);
		
		JButton submitCurrency = new JButton("Submit");
		commitSection.add(submitCurrency);
		
		panelSections.add(inputSection);
		panelSections.add(commitSection);
		
		submitCurrency.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codeInput = currencyCodeInput.getText().toUpperCase();
				rateInput = currencyRateInput.getText();
				
				switch(DisplayGUI.getInstance().getUserOptionsGUI().userOptions.getSelectedIndex()){
					//Add	
					case 1:	vi.checkCurrencyCodes(codeInput, null);
							vi.checkCurrencyRate(rateInput);
							m.addCurrencies(vi,vi);
							vi.setFromCode(null);
							break;
					//Remove
					case 2: vi.checkCurrencyCodes(codeInput, null);
							m.removeCurrencies(vi);
							vi.setFromCode(null);
							break;
					//Change
					case 3: vi.checkCurrencyCodes(codeInput, null);
							vi.checkCurrencyRate(rateInput);
							m.changeCurrencies(vi, vi);
							vi.setFromCode(null);
							vi.setCurrencyRate(0);
				}
			}
		});
	}//end
}//end of class
