package com.br.youtubeOasys.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ItemDTO {
	private String kind;
	private String etag;    
	private SnippetDTO snippet;
	private ItemIdDTO id;          
}
