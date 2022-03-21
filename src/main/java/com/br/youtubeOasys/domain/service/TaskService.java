package com.br.youtubeOasys.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.youtubeOasys.domain.model.TaskDTO;
import com.br.youtubeOasys.domain.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepository;
	
	public ResponseEntity<TaskDTO> create(String youtubeChannelId){
		TaskDTO task = new TaskDTO();	
		task.setChannelId(youtubeChannelId);
		TaskDTO taskCreated = taskRepository.save(task);	
		return ResponseEntity.ok(taskCreated);
	}
}
