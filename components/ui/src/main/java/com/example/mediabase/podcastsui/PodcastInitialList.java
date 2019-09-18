package com.example.mediabase.podcastsui;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PodcastInitialList {

    public List<PodcastUI> asList() {
        return Arrays.asList(new PodcastUI("Wedding Crashers", "David Dobkin", "Comedy"),
                new PodcastUI("Starsky & Hutch", "Todd Phillips", "Action"),
                new PodcastUI("Shanghai Knights", "David Dobkin", "Action"),
                new PodcastUI("I-Spy", "Betty Thomas", "Adventure"),
                new PodcastUI("The Royal Tenenbaums", "Wes Anderson", "Comedy"),
                new PodcastUI("Zoolander", "Ben Stiller", "Comedy"),
                new PodcastUI("Shanghai Noon", "Tom Dey", "Comedy")

        );
    }
}
