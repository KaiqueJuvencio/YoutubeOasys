package com.br.youtubeOasys.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ThumbnailDTO {

	private HighDTO high;

	public HighDTO getHigh() {
		return high;
	}

	public void setHigh(HighDTO high) {
		this.high = high;
	}
}