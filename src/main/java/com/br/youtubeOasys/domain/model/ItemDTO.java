package com.br.youtubeOasys.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDTO {
	private String kind;
	private String etag;    
	private SnippetDTO snippet;
	private ItemIdDTO id;
	
	public ItemIdDTO getId() {
		return id;
	}
	public void setId(ItemIdDTO id) {
		this.id = id;
	}
	public String getKind() {
		return kind;
	}
	public String getEtag() {
		return etag;
	}
	public SnippetDTO getSnippet() {
		return snippet;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public void setEtag(String etag) {
		this.etag = etag;
	}
	public void setSnippet(SnippetDTO snippet) {
		this.snippet = snippet;
	}           
}
