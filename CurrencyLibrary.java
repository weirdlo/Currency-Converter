package com.green.converterphaseVI;
import java.util.ArrayList;
import java.util.Arrays;
/*
 * Library to hold all currencies and rates with a list of valid currencies.
 */
public class CurrencyLibrary {
	private static  ArrayList<String> fromCurrencies = new ArrayList<String>();
	private static  ArrayList<Double> currentRates = new ArrayList<Double>();
	private static ArrayList<String> toCurrencies = new ArrayList<String>();
	private static final ArrayList<String> validCurrenciesList = new ArrayList<String>(Arrays.asList(
			"AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN",
			"BHD", "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTN", "BWP", "BYR", "BZD", "CAD", "CDF", "CHF",
			"CLP", "CNY", "COP", "CRC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "ECS", "EGP", "ERN",
			"ETB", "EUR", "FJD", "FKP", "GBP", "GEL", "GGP", "GHS", "GIP", "GMD", "GNF", "GWP", "GYD", "HKD",
			"HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "INR", "IQD", "IRR", "ISK", "JMD", "JOD", "JPY", "KES",
			"KGS", "KHR", "KMF", "KPW", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LTL",
			"LVL", "LYD", "MAD", "MDL", "MGF", "MKD", "MMK", "MNT", "MOP", "MRO", "MUR", "MVR", "MWK", "MXN", 
			"MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD",	"OMR", "PAB", "PEN", "PGK", "PHP", "PKR",
			"PLN", "PYG", "QAR", "QTQ",	"RON", "RSD", "RUB", "RWF",	"SAR", "SBD", "SCR", "SDG", "SEK", "SGD",
			"SHP", "SLL", "SOS", "SRD", "SSP", "STD", "SVC", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP",
			"TRY", "TTD", "TWD", "TZS",	"UAH", "UGX", "USD", "UYU", "UZS", "VEF", "VND", "VUV", "WST", "XAF", 
			"XCD", "XOF", "XPF", "YER",	"ZAR", "ZMW", "ZWD"));
			
	//Getters and setters
	public static ArrayList<String> getFromCurrencies() {
		return fromCurrencies;
	}
	
	public static ArrayList<Double> getCurrentRates() {
		return currentRates;
	}
	
	public static ArrayList<String> getToCurrencies() {
		return toCurrencies;
	}
	
	public static ArrayList<String> getValidCurrenciesList() {
		return validCurrenciesList;
	}
}//end of class
