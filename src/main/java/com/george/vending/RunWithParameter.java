package com.george.vending;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import com.george.vending.service.VendingService;

/**
 * 
 * @author Georgi Vasilski
 * @since 15.09.2018
 *
 */
public class RunWithParameter {

	public static void main(String[] args) throws Exception {
		
		System.out.println("*************** Starting the program ***************");
		
		final Option typeOfCurrency = new Option("c", "currency", true, "set the currency you wish to be displayed");
		final Options options = new Options();
		options.addOption(typeOfCurrency);
		
		final CommandLineParser parser = new DefaultParser();
		
		final CommandLine cmd = parser.parse(options, args, true);
		
		String currencyType = cmd.getOptionValue( typeOfCurrency.getLongOpt() );
		
		if( currencyType != null ) {
			System.out.println("currency is set to : " + currencyType);
			System.out.println();
			new VendingService().run(currencyType.toLowerCase());
		}else {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("vending machine", options);
		}


	}

}
