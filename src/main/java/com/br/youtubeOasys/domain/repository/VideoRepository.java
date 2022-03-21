package com.br.youtubeOasys.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.youtubeOasys.domain.model.VideoDTO;

@Repository
public interface VideoRepository extends JpaRepository<VideoDTO, Long>{
	
	List<VideoDTO> findByTasksId(Long taskId); 
}
