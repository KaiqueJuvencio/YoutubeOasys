package com.br.youtubeOasys.domain.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoDTO {
    public String kind;
    public String etag;  
    public ArrayList<Item> items;
    
    
}