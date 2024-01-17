package com.github.syndexmx.rsspodcastfetcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RssPodcastFetcherApplication {

	public static void main(String[] args) {

		SpringApplication.run(RssPodcastFetcherApplication.class, args);
		System.out.println("***  RSS-podcast fetcher service is on-line  ***");
	}

}
