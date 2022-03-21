package com.br.youtubeOasys.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.youtubeOasys.domain.model.TaskDTO;
import com.br.youtubeOasys.domain.model.VideoDTO;
import com.br.youtubeOasys.domain.model.YoutubeApiResponseDTO;
import com.br.youtubeOasys.domain.repository.VideoRepository;

@Service
public class VideoService {
	
	@Autowired
	VideoRepository videoRepository;
	
	@SuppressWarnings("unused")
	public ResponseEntity<List<VideoDTO>> create(ResponseEntity<YoutubeApiResponseDTO> youtubeRequest, TaskDTO task){
		List<VideoDTO> videos = new ArrayList<VideoDTO>();		
		youtubeRequest.getBody().getItems().forEach(item ->{
			VideoDTO video = new VideoDTO();
			video.setTitle(item.getSnippet().getTitle());
			video.setDescription(item.getSnippet().getDescription());
			video.setChannelTitle(item.getSnippet().getChannelTitle());
			video.setChannelId(item.getSnippet().getChannelId());
			video.setThumbnailUrl(item.getSnippet().getThumbnail().getHigh().getUrl());
			video.setVideoId(item.getId().getVideoId());
			videos.add(video);
			video.setTasks(task);											
		});	
		List<VideoDTO> videosCreated = videoRepository.saveAll(videos);
		return ResponseEntity.ok(videosCreated);
	}
	
	public List<VideoDTO> findByTaskId(Long taskId){
		return videoRepository.findByTasksId(taskId);
	}
}
