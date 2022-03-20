package com.br.youtubeOasys.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemIdDTO {
	private String kind;
	private String videoId;
	
	public String getKind() {
		return kind;
	}
	public String getVideoId() {
		return videoId;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}    			    
}
