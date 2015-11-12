package main.java.preload;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Constants {
	
	private static boolean loadedConstants = false;
	
	private static HashMap<String, String> constants = new HashMap<String, String>();
	
	/**
	 * 
	 * Shows whether constants from /resources/constants have been loaded.
	 * @return true if Constants.load() has been called previously, otherwise false.
	 */
	public static boolean isLoaded() {
		return loadedConstants;
	}
	
	/**
	 * Load all constants specified in files under folder: /resources/constants
	 */
	public static void load() {
		loadConstantsResources();
		loadedConstants = true;
	}
	
	public static String get( String identifier ) {
		return constants.get(identifier);
	}
	
	private static void loadConstantsResources() {
		try {
			Files.walk(Paths.get("resources/constants")).forEach(filePath -> {
			    try {
			    	if(!Files.isRegularFile(filePath)) 
			    		return;
					BufferedReader reader = Files.newBufferedReader(filePath);
					String nextLine;
					while((nextLine = reader.readLine()) != null) {
						if(nextLine.startsWith("#") || nextLine.isEmpty()) // ignores lines that start with #
							continue;
						String[] constantData = nextLine.split("=");
						if(constantData != null && constantData.length < 2)
							continue;
						String identifier = constantData[0];
						String value = constantData[1];
						constants.put(identifier, value);
					}
			    	
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
