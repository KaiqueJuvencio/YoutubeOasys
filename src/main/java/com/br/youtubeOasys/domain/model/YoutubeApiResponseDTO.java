package com.br.youtubeOasys.domain.model;

import java.util.ArrayList;

public class YoutubeApiResponseDTO {
	private String kind;
	private String etag;  
	private ArrayList<Item> items;
	
	public String getKind() {
		return kind;
	}
	public String getEtag() {
		return etag;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public void setEtag(String etag) {
		this.etag = etag;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}  
}