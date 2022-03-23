package com.br.youtubeOasys.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.youtubeOasys.domain.exception.BadRequestException;
import com.br.youtubeOasys.domain.model.TaskDTO;
import com.br.youtubeOasys.domain.model.VideoDTO;
import com.br.youtubeOasys.domain.model.YoutubeApiResponseDTO;
import com.br.youtubeOasys.domain.repository.VideoRepository;

import javassist.tools.web.BadHttpRequest;

@Service
public class VideoService {
	
	@Autowired
	VideoRepository videoRepository;
		
	public ResponseEntity<List<VideoDTO>> create(ResponseEntity<YoutubeApiResponseDTO> youtubeRequest, TaskDTO task){
		try {
			List<VideoDTO> videos = new ArrayList<VideoDTO>();		
			youtubeRequest.getBody().getItems().forEach(item ->{
				VideoDTO video = new VideoDTO();
				video.setTitle(item.getSnippet().getTitle());
				video.setDescription(item.getSnippet().getDescription());
				video.setChannelTitle(item.getSnippet().getChannelTitle());
				video.setChannelId(item.getSnippet().getChannelId());
				video.setThumbnailUrl(item.getSnippet().getThumbnail().getHigh().getUrl());
				video.setVideoId(item.getId().getVideoId());
				video.setUrl("https://www.youtube.com/watch?v="+video.getVideoId());
				videos.add(video);
				video.setTasks(task);											
			});	
			List<VideoDTO> videosCreated = videoRepository.saveAll(videos);
			return ResponseEntity.ok(videosCreated);
		}catch(Exception error){
			throw new BadRequestException("Error to create videos.");
		}		
	}
	
	public List<VideoDTO> findByTaskId(String taskId) throws BadHttpRequest{
		try {			
			return videoRepository.findByTasksId(Long.parseLong(taskId));
		}catch(Exception error){
			throw new BadRequestException("Error to find videos by task id.");
		}
	}
}
