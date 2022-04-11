package com.br.youtubeOasys.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SnippetDTO {	
	private String channelId;
	private String title;
	private String description;	
	private String channelTitle;
	private String liveBroadcastContent;
	@JsonProperty("thumbnails")
	private ThumbnailDTO thumbnail;
}
