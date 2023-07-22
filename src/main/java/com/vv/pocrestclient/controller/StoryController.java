package com.vv.pocrestclient.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vv.pocrestclient.client.StoryClient;
import com.vv.pocrestclient.model.Story;


import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class StoryController {

    @Autowired
    private StoryClient storyClient;


    @RequestMapping(value="/api/stories", method = RequestMethod.POST)
    public Story postOneStory(@RequestBody Story story) {
        return storyClient.saveNewStory( story );
    }

    @RequestMapping(value= "/api/stories/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getStoryById( @PathVariable( value = "id" ) Long storyId ) {
        return storyClient.getStory( storyId );
    }
}