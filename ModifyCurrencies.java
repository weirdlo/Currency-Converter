package com.green.converterphaseVI;
import javax.swing.JOptionPane;

public class ModifyCurrencies {
	private static String currencyCode = null;
	private static double currencyRate = 0;
	
	public void addCurrencies(ValidatingInputs newCurrency, ValidatingInputs newRate){
		int position = CurrencyLibrary.getFromCurrencies().indexOf(newCurrency.getFromCode());
		int validCurrency = CurrencyLibrary.getValidCurrenciesList().indexOf(newCurrency.getFromCode());
		
		if (position < 0){
			if (newCurrency.getFromCode() != null && newRate.getCurrencyRate() > 0){
				if (validCurrency >= 0){
					CurrencyLibrary.getFromCurrencies().add(newCurrency.getFromCode());
					CurrencyLibrary.getCurrentRates().add(newRate.getCurrencyRate());
					CurrencyLibrary.getToCurrencies().add(newCurrency.getFromCode());
					
					DisplayGUI.getInstance().getCurrencyConverterGUI().selectFromCurrency.addItem(newCurrency.getFromCode());
					DisplayGUI.getInstance().getCurrencyConverterGUI().selectToCurrency.addItem(newCurrency.getFromCode());
					
					currencyCode = newCurrency.getFromCode();
					currencyRate = newRate.getCurrencyRate();
					
					JOptionPane.showMessageDialog(null, newCurrency.getFromCode()+" with a rate of "+newRate.getCurrencyRate()+" has been added.");
					InsertIntoDatabase.connect();
					setCurrencyRate(0);
				}
				else 
					JOptionPane.showMessageDialog(null, newCurrency.getFromCode()+" is not a valid currency code.");
			}
		}
		else 
			JOptionPane.showMessageDialog(null, newCurrency.getFromCode()+" already exists.");
	}//end
	
	public void removeCurrencies(ValidatingInputs oldCurrency){
		int position = CurrencyLibrary.getFromCurrencies().indexOf(oldCurrency.getFromCode());
		
		if (oldCurrency.getFromCode() != null){
			if (position >= 0){
				CurrencyLibrary.getFromCurrencies().remove(oldCurrency.getFromCode());
				CurrencyLibrary.getCurrentRates().remove(position);
				CurrencyLibrary.getToCurrencies().remove(oldCurrency.getFromCode());
				
				DisplayGUI.getInstance().getCurrencyConverterGUI().selectFromCurrency.removeItem(oldCurrency.getFromCode());
				DisplayGUI.getInstance().getCurrencyConverterGUI().selectToCurrency.removeItem(oldCurrency.getFromCode());
				
				currencyCode = oldCurrency.getFromCode();
				InsertIntoDatabase.connect();
				
				JOptionPane.showMessageDialog(null, oldCurrency.getFromCode()+" has been successfully removed.");
			}
			else
				JOptionPane.showMessageDialog(null, oldCurrency.getFromCode()+" does not exist.");
		}
	}//end
	
	public void changeCurrencies(ValidatingInputs modifyCode, ValidatingInputs newRate){
		int position = CurrencyLibrary.getFromCurrencies().indexOf(modifyCode.getFromCode());
		
		if (newRate.getCurrencyRate() > 0 && modifyCode.getFromCode() != null){
			if (position >= 0){
				String strCurrencyCode = CurrencyLibrary.getFromCurrencies().get(position);
				
				if (strCurrencyCode.equals(modifyCode.getFromCode())){
					CurrencyLibrary.getCurrentRates().set(position, newRate.getCurrencyRate());
					
					JOptionPane.showMessageDialog(null, "The new rate for "+modifyCode.getFromCode()+" is $"+newRate.getCurrencyRate());
					
					currencyCode = modifyCode.getFromCode();
					currencyRate = newRate.getCurrencyRate();
					InsertIntoDatabase.connect();
					setCurrencyRate(0);
				}
			}
			else
				JOptionPane.showMessageDialog(null, modifyCode.getFromCode()+" does not exist.");
		}
	}//end
	
	public static void showAllCurrencies(){
		String[] currentCurrencies = new String [CurrencyLibrary.getFromCurrencies().size()];
		Double[] currentRates = new Double [CurrencyLibrary.getCurrentRates().size()];
		
		currentCurrencies = CurrencyLibrary.getFromCurrencies().toArray(currentCurrencies);
		currentRates = CurrencyLibrary.getCurrentRates().toArray(currentRates);
		
		System.out.println("All Currencies: ");
		for(int i = 0; i < currentCurrencies.length; i++)
			System.out.println(currentCurrencies[i]+"---------->$"+currentRates[i]);
	}//end
	
	//Getters and Setters
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public double getCurrencyRate() {
		return currencyRate;
	}

	public void setCurrencyRate(double currencyRate) {
		this.currencyRate = currencyRate;
	}
}//end of class
