package com.br.youtubeOasys.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="TB_VIDEO")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
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
	private String url;
	@ManyToOne
	@JoinColumn
	private TaskDTO tasks;
}