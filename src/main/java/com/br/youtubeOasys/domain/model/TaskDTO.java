package com.br.youtubeOasys.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="TB_TASK")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String channelId;
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "channelId", targetEntity = VideoDTO.class)	 
//	private List<VideoDTO> videos;			
	
//	public List<VideoDTO> getVideos() {
//		return videos;
//	}
//	public void setVideos(List<VideoDTO> videos) {
//		this.videos = videos;
//	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}			
}