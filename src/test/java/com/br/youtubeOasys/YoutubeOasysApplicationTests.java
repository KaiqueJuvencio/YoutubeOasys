package com.br.youtubeOasys;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.br.youtubeOasys.domain.model.TaskDTO;
import com.br.youtubeOasys.domain.model.YoutubeApiResponseDTO;
import com.br.youtubeOasys.domain.repository.TaskRepository;
import com.br.youtubeOasys.domain.service.YoutubeApiService;

@Testcontainers
@SpringBootTest
class YoutubeOasysApplicationTests {
	
	@Autowired
	private TaskRepository taskRespository;
	
	@Autowired
	private YoutubeApiService youtubeApiService;
	
	@SuppressWarnings({ "deprecation", "rawtypes" })
	@Container
	public static PostgreSQLContainer container = new PostgreSQLContainer()
			.withUsername("postgres")
			.withPassword("Postgres2019!")
			.withDatabaseName("postgresql");			
	
	@DynamicPropertySource
	static void properties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", container::getJdbcUrl);
		registry.add("spring.datasource.password", container::getPassword);
		registry.add("spring.datasource.username", container::getUsername);
	}

	@Test
	void contextLoads() {
		System.out.println("Context Load");		
	}
	
	@Test
	void testDataBase() {
		TaskDTO task = new TaskDTO();
		task.setChannelId("TestContainer");
		task.setId(1L);
		testDataBaseSave(task);
		testDataBaseRead();				
	}
	
	public void testDataBaseSave(TaskDTO task) {
		TaskDTO taskSaved = taskRespository.save(task);
		assertEquals(taskSaved.getChannelId(), "TestContainer");
		assertEquals(taskSaved.getId(), 1L);
	}
	
	public void testDataBaseRead() {
		Optional<TaskDTO> taskRead = taskRespository.findById(1L);
		assertEquals(taskRead.get().getChannelId(), "TestContainer");
		assertEquals(taskRead.get().getId(), 1L);	
	}
	
	@Test
	public void testYoutubeApi() {
		String youtubeChannelId = "UCX6OQ3DkcsbYNE6H8uQQuVA";
		ResponseEntity<YoutubeApiResponseDTO> youtubeApiResponse = youtubeApiService.callApi(youtubeChannelId);
		assertEquals(youtubeApiResponse.getStatusCodeValue(), 200);
	}

}
