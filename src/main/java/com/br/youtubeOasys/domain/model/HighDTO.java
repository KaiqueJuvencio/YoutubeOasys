package com.br.youtubeOasys.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class HighDTO {	
	private String url;
	private String width;
	private String height;		
}