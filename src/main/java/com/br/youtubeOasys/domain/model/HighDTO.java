package com.br.youtubeOasys.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HighDTO {
	
	private String url;
	private String width;
	private String height;
	
	public String getUrl() {
		return url;
	}
	public String getWidth() {
		return width;
	}
	public String getHeight() {
		return height;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public void setHeight(String height) {
		this.height = height;
	}		
}