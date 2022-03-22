package com.br.youtubeOasys.domain.model;

import java.util.ArrayList;

public class YoutubeApiResponseDTO {
	private String kind;
	private String etag;  
	private ArrayList<ItemDTO> items;
	
	public String getKind() {
		return kind;
	}
	public String getEtag() {
		return etag;
	}
	public ArrayList<ItemDTO> getItems() {
		return items;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public void setEtag(String etag) {
		this.etag = etag;
	}
	public void setItems(ArrayList<ItemDTO> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "YoutubeApiResponseDTO [kind=" + kind + ", etag=" + etag + ", items=" + items + ", getKind()="
				+ getKind() + ", getEtag()=" + getEtag() + ", getItems()=" + getItems() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}  	
	
}