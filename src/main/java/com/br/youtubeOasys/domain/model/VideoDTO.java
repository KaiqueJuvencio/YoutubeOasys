package com.br.youtubeOasys.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="TB_VIDEO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String videoId;
	private String title;  
	private String description;
	private String channelId;
	private String channelTitle;
	private String thumbnailUrl;
	public long getId() {
		return id;
	}
	public String getVideoId() {
		return videoId;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getChannelId() {
		return channelId;
	}
	public String getChannelTitle() {
		return channelTitle;
	}
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public void setChannelTitle(String channelTitle) {
		this.channelTitle = channelTitle;
	}
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}		
}