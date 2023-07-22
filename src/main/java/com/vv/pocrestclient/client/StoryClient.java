package com.vv.pocrestclient.client;


import com.vv.pocrestclient.model.Story;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class StoryClient {

    public final String STORY_PATH_V1 = "https://jsonplaceholder.typicode.com/posts";

    private final RestTemplate restTemplate;

    public StoryClient( RestTemplateBuilder restTemplateBuilder ) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Story saveNewStory( Story story ) {
        final String madeURL = STORY_PATH_V1 ;
        log.error( "URL:"+ madeURL);
        Story story1 = restTemplate.postForObject( madeURL, story, Story.class );
        log.error("VV1 j:{}",story1);
        return story1;
    }

    public ResponseEntity<String> getStory( Long storyId ) {
        final String madeURL = String.format( STORY_PATH_V1 + "/%d", storyId );
        log.error( "URL:"+ madeURL);
        ResponseEntity<String> result = restTemplate.getForEntity( madeURL, String.class );
        return result;
    }
}
