package com.br.youtubeOasys.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ItemIdDTO {
	private String kind;
	private String videoId;   			    
}
