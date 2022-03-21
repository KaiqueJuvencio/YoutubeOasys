package com.br.youtubeOasys.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.youtubeOasys.domain.model.TaskDTO;

@Repository
public interface TaskRepository extends JpaRepository<TaskDTO, Long>{
	
}
