package com.example.mediabase;

import com.example.mediabase.moviesui.MovieClient;
import com.example.mediabase.moviesui.MoviesInitialList;
import com.example.mediabase.podcastsui.PodcastClient;
import com.example.mediabase.podcastsui.PodcastInitialList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class RootController {
    private  MovieClient movieClient;
    private PodcastClient podcastClient;
    private MoviesInitialList moviesInitialList;
    private PodcastInitialList podcastInitialList;


    public RootController(MovieClient movieClient, PodcastClient podcastClient,MoviesInitialList moviesInitialList,PodcastInitialList podcastInitialList) {

        this.movieClient = movieClient;
        this.podcastClient = podcastClient;
        this.moviesInitialList=moviesInitialList;
        this.podcastInitialList=podcastInitialList;
    }

    @GetMapping("/")
    public String rootPath() {
        return "index";
    }

    @GetMapping("/setup")
    public String setupDatabase(Map<String,Object> model) {

        moviesInitialList.asList().forEach(movieClient::create);
        model.put("movies", movieClient.getAll());
        podcastInitialList.asList().forEach(podcastClient::create);
        model.put("podcasts", podcastClient.getAll());

        return "setup";
    }

}
