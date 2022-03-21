package com.br.youtubeOasys.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.youtubeOasys.domain.model.TaskDTO;
import com.br.youtubeOasys.domain.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepository;
	
	public TaskDTO create(String youtubeChannelId){
		TaskDTO task = new TaskDTO(youtubeChannelId);		
		return taskRepository.save(task);		
	}
	
	public List<TaskDTO> findAll(){			
		return taskRepository.findAll();
	}
}
