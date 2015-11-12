package main.java;

import main.java.preload.Constants;

public class main {

	public static void main(String[] args) {
		if(!Constants.isLoaded())
			Constants.load();
		
		System.out.println(Constants.get("sc_api_endpoint"));
		System.out.println(Constants.get("sc_api_key"));
		System.out.println(Constants.get("otherstuff"));

	}

}
