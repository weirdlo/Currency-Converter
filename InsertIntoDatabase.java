package com.green.converterphaseVI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * For results to get placed into the SQLite database.
 * Download jdbc for this.
 */
public class InsertIntoDatabase {
	private static Connection conn = null;
	
	public static void connect(){
		ModifyCurrencies mc = new ModifyCurrencies();
		ConvertCurrencies cc = new ConvertCurrencies();
		try{
            String url = "jdbc:sqlite:C:/Users/Ashley.green/workspace/phase6.db";  //database file
            conn = DriverManager.getConnection(url); // create a connection to the database
            System.out.printf("\n%s\n","Connection to SQLite has been established...");

            //To insert data into the database
            switch (DisplayGUI.getInstance().getUserOptionsGUI().userOptions.getSelectedIndex()){
	            case 0: PreparedStatement prep0 = conn.prepareStatement("INSERT INTO CurrencyConversions (AmountInput, FromCurrencyCode, CurrencyRateOutput, ToCurrencyCode) VALUES (?,?,?,?)");
			        	prep0.setDouble(1, cc.getFromRate());
			        	prep0.setString(2, cc.getFromCurrencyCode());
			        	prep0.setDouble(3, cc.getToRate());
			        	prep0.setString(4, cc.getToCurrencyCode());
			        	prep0.executeUpdate();
			        	break;
	            case 1:	PreparedStatement prep1 = conn.prepareStatement("INSERT INTO CurrencyConverter (FromCurrency, CurrencyRate) VALUES (?,?)");
		            	prep1.setString(1, mc.getCurrencyCode());
		            	prep1.setDouble(2, mc.getCurrencyRate());
		            	prep1.executeUpdate(); break;
	            case 2:	PreparedStatement prep2 = conn.prepareStatement("DELETE FROM CurrencyConverter WHERE FromCurrency = ?");
		            	prep2.setString(1,mc.getCurrencyCode());
		            	prep2.executeUpdate(); 
		            	break;
	            case 3:	PreparedStatement prep3 = conn.prepareStatement("UPDATE CurrencyConverter SET CurrencyRate = ? WHERE FromCurrency = ?");
		            	prep3.setString(2, mc.getCurrencyCode());
		            	prep3.setDouble(1, mc.getCurrencyRate());
		            	prep3.executeUpdate();
		            	PreparedStatement clearConversions = conn.prepareStatement("DELETE FROM CurrencyConversions WHERE FromCurrencyCode = ? OR ToCurrencyCode = ?");
		            	clearConversions.setString(1, mc.getCurrencyCode());
		            	clearConversions.setString(2, mc.getCurrencyCode());
		            	clearConversions.executeUpdate(); break;
            }
            
            ModifyCurrencies.showAllCurrencies(); //to show all current currencies with their rates
            
            //To display the value of all converted currencies
            ResultSet conversions = conn.prepareStatement("SELECT * FROM CurrencyConversions").executeQuery();
            System.out.printf("\n%s\n","List of Converted Currencies:");
            while (conversions.next()){
            	System.out.println(conversions.getString("AmountInput")+" "+conversions.getString("FromCurrencyCode")+" <----> "+conversions.getString("CurrencyRateOutput")+" "+conversions.getString("ToCurrencyCode"));
            }
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
}//end of class