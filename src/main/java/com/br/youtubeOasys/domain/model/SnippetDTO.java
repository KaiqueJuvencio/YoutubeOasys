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
	
	public String getChannelId() {
		return channelId;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getChannelTitle() {
		return channelTitle;
	}
	public String getLiveBroadcastContent() {
		return liveBroadcastContent;
	}
	public ThumbnailDTO getThumbnail() {
		return thumbnail;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setChannelTitle(String channelTitle) {
		this.channelTitle = channelTitle;
	}
	public void setLiveBroadcastContent(String liveBroadcastContent) {
		this.liveBroadcastContent = liveBroadcastContent;
	}
	public void setThumbnail(ThumbnailDTO thumbnail) {
		this.thumbnail = thumbnail;
	}					
}
