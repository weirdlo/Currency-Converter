package com.green.converterphaseVI;

public class ConvertCurrencies {
	String displayOutput;
	private static String toCurrencyCode, fromCurrencyCode;
	private static double fromRate, toRate;
	
	public void convertCurrency(ValidatingInputs rate){
		int fromPosition = DisplayGUI.getInstance().getCurrencyConverterGUI().selectFromCurrency.getSelectedIndex(),
			toPosition = DisplayGUI.getInstance().getCurrencyConverterGUI().selectToCurrency.getSelectedIndex();
		fromCurrencyCode = CurrencyLibrary.getFromCurrencies().get(fromPosition);
		toCurrencyCode = CurrencyLibrary.getFromCurrencies().get(toPosition);

		if(rate.getCurrencyRate() > 0){
			if(CurrencyLibrary.getCurrentRates().get(toPosition) != null){
				double currentRate = CurrencyLibrary.getCurrentRates().get(toPosition); 
				fromRate = rate.getCurrencyRate();
				
				if(fromPosition == toPosition){
					toRate = (double) Math.round(fromRate * 100) / 100;
					displayOutput = fromRate+" "+fromCurrencyCode+" = "+toRate+" "+toCurrencyCode;
				}
				else{
					toRate = (double) Math.round((currentRate * fromRate) * 100) / 100;
					UpdateCurrencyLibrary.convertedCurrencySearch();
					if (UpdateCurrencyLibrary.isFound()){
						displayOutput = fromRate+" "+fromCurrencyCode+" = "+toRate+" "+toCurrencyCode;
						UpdateCurrencyLibrary.setFound(false);
					}
					else{
						displayOutput = fromRate+" "+fromCurrencyCode+" = "+toRate+" "+toCurrencyCode;
						InsertIntoDatabase.connect();
					}
				}
			}
		}
	}//end

	//Getters and Setters
	public static String getToCurrencyCode() {
		return toCurrencyCode;
	}

	public static String getFromCurrencyCode() {
		return fromCurrencyCode;
	}

	public static double getFromRate() {
		return fromRate;
	}

	public double getToRate() {
		return toRate;
	}

	public void setToRate(double toRate) {
		this.toRate = toRate;
	}
}//end of class
