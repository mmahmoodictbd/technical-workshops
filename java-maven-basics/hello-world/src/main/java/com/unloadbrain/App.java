package com.unloadbrain;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class App {

	public static void main(String[] args) {

		System.out.println("Hello World!");

		Document prothomAloPage;
		try {
			prothomAloPage = Jsoup.parse(new URL("https://www.prothomalo.com/"), 10000);
		} catch (IOException e) {
			throw new RuntimeException("Could not download document.", e);
		}

		System.out.println(prothomAloPage.select("#header time").text());
	}
}
