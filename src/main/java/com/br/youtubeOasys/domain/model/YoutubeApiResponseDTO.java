package com.br.youtubeOasys.domain.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class YoutubeApiResponseDTO {
	private String kind;
	private String etag;  
	private ArrayList<ItemDTO> items;	
}