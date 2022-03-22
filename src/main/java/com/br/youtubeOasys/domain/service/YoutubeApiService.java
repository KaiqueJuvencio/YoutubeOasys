package com.br.youtubeOasys.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.youtubeOasys.domain.exception.BadRequestException;
import com.br.youtubeOasys.domain.model.YoutubeApiResponseDTO;

@Service
public class YoutubeApiService {	
	@Autowired
	FeignRequest feignRequest;	
	
	public ResponseEntity<YoutubeApiResponseDTO> callApi(String youtubeChannelId){
		String errorMessage = "Error in Youtube Api call.";
		try {	
			ResponseEntity<YoutubeApiResponseDTO> youtubeResponse = 
					feignRequest.request(youtubeChannelId);
			Boolean withoutItems = youtubeResponse.getBody().getItems().isEmpty();
			if(withoutItems) {
				errorMessage = "Please submit an valid channel id.";			
				throw new BadRequestException(errorMessage);
			}
			return youtubeResponse;
		}catch(Exception error){
			throw new BadRequestException(errorMessage);
		}
	}
	
}
