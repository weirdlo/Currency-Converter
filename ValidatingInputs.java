package com.green.converterphaseVI;
import javax.swing.JOptionPane;
/*
 * Gets all of the inputs from the user.
 * If everything checks out, it sends the inputs to their designated method.
 * If not, it notifies the user of the error and starts the program from the beginning.
 */
public class ValidatingInputs {
	private double currencyRate; //to hold the inputs for the currency rates
	private String fromCode = null, toCode = null; // to hold inputs for currency codes & for better error checking for methods
	
	public void checkCurrencyCodes(String fromCurrencyCode, String toCurrencyCode){
		try{
			if (fromCurrencyCode != null)
				if (!fromCurrencyCode.matches("[a-zA-Z]+") || fromCurrencyCode.length() != 3)
					throw new Exception();	
				else 
					fromCode = fromCurrencyCode;
					
			//Will only be used for the method to convert currencies
			if (toCurrencyCode != null)
				if (!toCurrencyCode.matches("[a-zA-Z]+") || toCurrencyCode.length() != 3)
					throw new Exception();
				else 
					toCode = toCurrencyCode;
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Currency code should be alphabetical and three characters long.");
			fromCurrencyCode = null; toCurrencyCode = null;
		}
	}//end
			
	public void checkCurrencyRate(String rate){
		try{
			if (rate != null && rate.length() < 11){
				currencyRate = Double.parseDouble(rate);
				
				if (currencyRate <= 0)
					throw new NumberFormatException();
			}
			else
				throw new NumberFormatException();
		}
		catch (NumberFormatException ex){
			JOptionPane.showMessageDialog(null, "Currency rate should be a monetary value greater than $0.");
		}
	}//end
	
	//Getters and Setters
	public double getCurrencyRate() {
		return currencyRate;
	}

	public void setCurrencyRate(double currencyRate) {
		this.currencyRate = currencyRate;
	}
	
	public String getFromCode() {
		return fromCode;
	}

	public void setFromCode(String fromCode) {
		this.fromCode = fromCode;
	}

	public String getToCode() {
		return toCode;
	}

	public void setToCode(String toCode) {
		this.toCode = toCode;
	}
}//end of class
