package com.vv.pocrestclient.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder( toBuilder = true )

public class Story {

    private Long userId;
    private Long id;
    private String title;
    private String body;

}