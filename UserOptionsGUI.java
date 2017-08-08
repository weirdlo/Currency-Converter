package com.green.converterphaseVI;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class UserOptionsGUI extends JPanel{
	ModifyCurrencies changes = new ModifyCurrencies();
	static JList userOptions;
	
	public UserOptionsGUI(){
		JPanel userOptionsLayout = new JPanel(new GridLayout(1,2));
		add(userOptionsLayout);
		
		JLabel instructions = new JLabel("Select one of the options to get started: ");
		String[] options = {"Convert Currency", "Add New Currency", "Remove Existing Currency", "Modify Existing Currency"};
		userOptions = new JList(options);
		
		userOptionsLayout.add(instructions);
		userOptionsLayout.add(userOptions);
		userOptionsLayout.add(new JScrollPane(userOptions));
		
		//To get selected item from menu
	    userOptions.addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event){
	        	if (!event.getValueIsAdjusting()){
	            	switch(userOptions.getSelectedIndex()){
	            		//Convert
		            	case 0: DisplayGUI.getInstance().getCurrencyConverterGUI().currencyRateInput.setEditable(true); 
		            			DisplayGUI.getInstance().getModificationsGUI().currencyCodeInput.setEditable(false);
		            			DisplayGUI.getInstance().getModificationsGUI().currencyCodeInput.setText(null);
		            			DisplayGUI.getInstance().getModificationsGUI().currencyRateInput.setEditable(false); 
		            			DisplayGUI.getInstance().getModificationsGUI().currencyRateInput.setText(null); 
		            			break;
            			//Add
		            	case 1: DisplayGUI.getInstance().getCurrencyConverterGUI().currencyRateInput.setEditable(false); 
		            			DisplayGUI.getInstance().getCurrencyConverterGUI().currencyRateInput.setText(null);
		            			DisplayGUI.getInstance().getCurrencyConverterGUI().convertedCurrencyOutput.setText(null);
		            			DisplayGUI.getInstance().getModificationsGUI().currencyCodeInput.setEditable(true); 	
		            			DisplayGUI.getInstance().getModificationsGUI().currencyRateInput.setEditable(true);
		            			DisplayGUI.getInstance().getModificationsGUI().currencyRateInput.setText(null);
		            			break;
		            	//Remove		
		            	case 2: DisplayGUI.getInstance().getCurrencyConverterGUI().currencyRateInput.setEditable(false);
		            			DisplayGUI.getInstance().getCurrencyConverterGUI().currencyRateInput.setText(null);
		            			DisplayGUI.getInstance().getCurrencyConverterGUI().convertedCurrencyOutput.setText(null);
		            			DisplayGUI.getInstance().getModificationsGUI().currencyCodeInput.setEditable(true); 	
		            			DisplayGUI.getInstance().getModificationsGUI().currencyRateInput.setEditable(false);
		            			DisplayGUI.getInstance().getModificationsGUI().currencyRateInput.setText(null);
		            			break;
            			//Modify
		            	case 3: DisplayGUI.getInstance().getCurrencyConverterGUI().currencyRateInput.setEditable(false); 
		            			DisplayGUI.getInstance().getCurrencyConverterGUI().currencyRateInput.setText(null); 
		            			DisplayGUI.getInstance().getCurrencyConverterGUI().convertedCurrencyOutput.setText(null); 
            					DisplayGUI.getInstance().getModificationsGUI().currencyCodeInput.setEditable(true); 	
            					DisplayGUI.getInstance().getModificationsGUI().currencyRateInput.setEditable(true);   
		            			break;	
	            	}
	            }
	        }
	    });
	}//end
}//end of class
