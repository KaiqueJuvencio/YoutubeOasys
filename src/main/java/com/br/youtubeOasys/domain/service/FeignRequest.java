package com.br.youtubeOasys.domain.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.br.youtubeOasys.domain.model.YoutubeApiResponseDTO;

@FeignClient(name = "qualp", url = "https://youtube.googleapis.com/youtube/v3/")
public interface FeignRequest {
	@GetMapping(value = "search?order=viewcount&part=snippet&channelId={youtubeChannelId}&key=AIzaSyAGOQRRzpVRqPtT7hXg1aNW9ffETkGX_tg",
				produces = "application/json")
	public ResponseEntity<YoutubeApiResponseDTO> request(@PathVariable("youtubeChannelId") String youtubeChannelId);
}
