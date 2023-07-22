package com.vv.pocrestclient.client;


import com.vv.pocrestclient.model.Story;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
@Slf4j
@RequiredArgsConstructor
public class StoryClient {

    public final String STORY_PATH_V1 = "https://jsonplaceholder.typicode.com/posts";

    RestClient restClient = RestClient.create();


    public ResponseEntity<String> getStory( Long storyId ) {
        final String madeURL = String.format( STORY_PATH_V1 + "/%d", storyId );
        log.error( "URL:" + madeURL );
        String result = restClient.get()
                                  .uri( madeURL )
                                  .retrieve()
                                  .body( String.class );
        return ResponseEntity.of( Optional.of( result ) );
    }

    public Story saveNewStory( Story story ) {
        final String madeURL = STORY_PATH_V1;
        log.error( "URL:" + madeURL );
        Story story1 = restClient.post()
                                 .uri( madeURL )
                                 .contentType( APPLICATION_JSON )
                                 .body( story )
                                 .retrieve()
                                 .toEntity( Story.class )
                                 .getBody();
        log.error( "VV1 j:{}", story1 );
        return story1;
    }

}
