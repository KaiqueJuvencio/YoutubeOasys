package com.br.youtubeOasys.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseGitHub {
	public final String id;
    public final String name;  
    public final String bio;
    
    public ResponseGitHub(@JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("bio") String bio) {
    this.id = id;
    this.name = name;
    this.bio = bio;
}
}
