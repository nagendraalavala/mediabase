package com.example.mediabase.podcastsui;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class PodcastController
{
    PodcastClient podcastClient;

    public PodcastController(PodcastClient podcastClient)
    {
        this.podcastClient=podcastClient;
    }
    @GetMapping("/podcasts")
    public String getAll(Map<String,Object> model)
    {
        model.put("podcasts",podcastClient.getAll());
        return "podcasts";
    }

}