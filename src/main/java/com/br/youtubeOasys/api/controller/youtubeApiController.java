package com.br.youtubeOasys.api.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.youtubeOasys.domain.model.VideoDTO;
import com.br.youtubeOasys.domain.model.YoutubeApiResponseDTO;
import com.br.youtubeOasys.domain.repository.VideoRepository;
import com.br.youtubeOasys.domain.service.FeignRequest;

@RestController
@RequestMapping("/api")
public class youtubeApiController {
	
	@Autowired
	FeignRequest feignRequest;
	
	@Autowired
	VideoRepository videoRepository;

	@PostMapping("/tasks/{youtubeChannelId}")
	public List<VideoDTO> createTask(@PathVariable String youtubeChannelId) {
		ResponseEntity<YoutubeApiResponseDTO> rep = feignRequest.request(youtubeChannelId);
		List<VideoDTO> videos = new ArrayList<VideoDTO>();
		rep.getBody().getItems().forEach(item ->{
			VideoDTO video = new VideoDTO();	
			video.setTitle(item.getSnippet().getTitle());
			video.setDescription(item.getSnippet().getDescription());
			video.setChannelTitle(item.getSnippet().getChannelTitle());
			video.setChannelId(item.getSnippet().getChannelId());
			video.setThumbnailUrl(item.getSnippet().getThumbnail().getHigh().getUrl());
			video.setVideoId(item.getId().getVideoId());
			videos.add(video);
			videoRepository.save(video);
		});	
		return videoRepository.findAll();
	}

	@GetMapping("/tasks")
	public String getTasks() throws IOException, InterruptedException {			
		return "Teste";		 
	}

	@GetMapping("/tasks/{taskId}")
	public String getVideos() {
		return "lista de videos";
	}
}
