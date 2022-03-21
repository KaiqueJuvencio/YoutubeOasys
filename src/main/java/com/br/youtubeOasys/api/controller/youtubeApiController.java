package com.br.youtubeOasys.api.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.youtubeOasys.domain.model.TaskDTO;
import com.br.youtubeOasys.domain.model.YoutubeApiResponseDTO;
import com.br.youtubeOasys.domain.service.FeignRequest;
import com.br.youtubeOasys.domain.service.TaskService;
import com.br.youtubeOasys.domain.service.VideoService;

@RestController
@RequestMapping("/api")
public class youtubeApiController {
	
	@Autowired
	FeignRequest feignRequest;	
	@Autowired
	TaskService taskService;	
	@Autowired
	VideoService videoService;

	@PostMapping("/tasks/{youtubeChannelId}")
	public ResponseEntity<TaskDTO> createTask(@PathVariable String youtubeChannelId) {
		ResponseEntity<YoutubeApiResponseDTO> youtubeRequest = feignRequest.request(youtubeChannelId);
		TaskDTO taskCreated = taskService.create(youtubeChannelId).getBody();
		videoService.create(youtubeRequest, taskCreated);												
		return ResponseEntity.ok(taskCreated);
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
