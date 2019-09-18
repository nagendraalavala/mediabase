package com.example.mediabase.podcastsui;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;
import java.util.*;

public class PodcastClient {
    private static ParameterizedTypeReference<List<PodcastUI>> podcastistType = new ParameterizedTypeReference<List<PodcastUI>>() {
    };
    private RestOperations restOperations;
    private String podcastURL;


    public PodcastClient(String podcastURL, RestOperations restOperations) {
        this.restOperations = restOperations;
        this.podcastURL = podcastURL;

    }
    public void create(PodcastUI podcast) {
        restOperations.postForEntity(podcastURL, podcast, PodcastUI.class);
    }
    public List<PodcastUI> getAll() {
        return restOperations.exchange(podcastURL, HttpMethod.GET, null, podcastistType).getBody();
    }

}
