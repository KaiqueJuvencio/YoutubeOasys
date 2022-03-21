package com.br.youtubeOasys.api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.youtubeOasys.domain.model.TaskDTO;
import com.br.youtubeOasys.domain.model.VideoDTO;
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
		TaskDTO taskCreated = taskService.create(youtubeChannelId);
		videoService.create(youtubeRequest, taskCreated);												
		return ResponseEntity.ok(taskCreated);
	}

	@GetMapping("/tasks")
	public ResponseEntity<List<TaskDTO>> getTasks() throws IOException, InterruptedException {			
		return ResponseEntity.ok(taskService.findAll());		 
	}

	@GetMapping("/tasks/{taskId}")
	public ResponseEntity<List<VideoDTO>> getVideos(@PathVariable Long taskId) {
		return ResponseEntity.ok(videoService.findByTaskId(taskId));
	}
}
