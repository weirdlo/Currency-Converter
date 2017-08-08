package com.green.converterphaseVI;
/*
 * This is used to update the JComboBox for the Currency Conversion GUI, and the currency library.
 * When the program starts, this automatically updates so its information matches that of the database.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateCurrencyLibrary {
	private static Connection conn = null;
	private static String url = "jdbc:sqlite:C:/Users/Ashley.green/workspace/phase6.db"; //database file
	private static boolean found = false;
	
	public static void updateCurrencies(){
		try{
			conn = DriverManager.getConnection(url); // create a connection to the database
            System.out.printf("%s\n","Updating information...*Plays elevator music (^_^)*...");
            
            //Making updates
            ResultSet currencyRates = conn.prepareStatement("SELECT * FROM CurrencyConverter").executeQuery();
            while (currencyRates.next()){
            	CurrencyLibrary.getFromCurrencies().add(currencyRates.getString("FromCurrency"));
				CurrencyLibrary.getCurrentRates().add(currencyRates.getDouble("CurrencyRate"));
				CurrencyLibrary.getToCurrencies().add(currencyRates.getString("FromCurrency"));
				
				DisplayGUI.getInstance().getCurrencyConverterGUI().selectFromCurrency.addItem(currencyRates.getString("FromCurrency"));
				DisplayGUI.getInstance().getCurrencyConverterGUI().selectToCurrency.addItem(currencyRates.getString("FromCurrency"));
            }
              
            System.out.println("Currently in the library.....");
			ModifyCurrencies.showAllCurrencies();
        	System.out.println("All done.  Make a selection to get started.");
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		finally {
			try{
				if (conn != null)
					conn.close();
			}
			catch (SQLException ex){
				System.out.println(ex.getMessage());
			}
		}
	}//end
	
	public static void convertedCurrencySearch(){
		try{
			conn = DriverManager.getConnection(url); // create a connection to the database
			System.out.printf("\n%s\n","Searching...");
			ConvertCurrencies cc = new ConvertCurrencies();
			ResultSet search = conn.prepareStatement("SELECT * FROM CurrencyConversions").executeQuery();
			while (search.next()){
				String fromCode = search.getString("ToCurrencyCode");
				double rate = search.getDouble("CurrencyRateOutput");
				String toCode = search.getString("FromCurrencyCode");
				if (fromCode.matches(ConvertCurrencies.getFromCurrencyCode()) && rate == ConvertCurrencies.getFromRate() && toCode.matches(ConvertCurrencies.getToCurrencyCode())){
					found = true;
					System.out.println("FOUND IT!");
					cc.setToRate(search.getDouble("AmountInput"));
					break;
				}
			}
			System.out.println("Search finished.");
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		finally {
			try{
				if (conn != null)
					conn.close();
			}
			catch (SQLException ex){
				System.out.println(ex.getMessage());
			}
		}
	}//end

	public static boolean isFound() {
		return found;
	}

	public static void setFound(boolean found) {
		UpdateCurrencyLibrary.found = found;
	}
}//end of class
