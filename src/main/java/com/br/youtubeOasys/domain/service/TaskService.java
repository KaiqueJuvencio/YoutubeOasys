package com.br.youtubeOasys.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.youtubeOasys.domain.exception.BadRequestException;
import com.br.youtubeOasys.domain.model.TaskDTO;
import com.br.youtubeOasys.domain.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepository;
	
	public TaskDTO create(String youtubeChannelId){
		try {			
			TaskDTO task = new TaskDTO(youtubeChannelId);		
			return taskRepository.save(task);		
		}catch(Exception error) {
			throw new BadRequestException("Error to create task.");
		}
	}
	
	public List<TaskDTO> findAll(){
		try {
			return taskRepository.findAll();	
		}catch(Exception error) {
			throw new BadRequestException("Error to find all tasks.");
		}		
	}
}
