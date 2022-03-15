package com.br.youtubeOasys.api.controller;

import java.io.IOException;
import java.util.Map;

import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.youtubeOasys.domain.model.ResponseGitHub;
import com.br.youtubeOasys.domain.model.VideoDTO;
import com.br.youtubeOasys.domain.service.FeignRequest;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@RestController
@RequestMapping("/api")
public class youtubeApiController {
	
	@Autowired
	FeignRequest feignRequest;

	@PostMapping("/tasks/{youtubeChannelId}")
	public String createTask() {
		return "task criada";
	}

	@GetMapping("/tasks")
	public String getTasks() throws IOException, InterruptedException {
//		ObjectMapper mapper = new ObjectMapper();
//		OkHttpClient client = new OkHttpClient();
//
//		Request request = new Request.Builder().url(
//				"https://youtube.googleapis.com/youtube/v3/search?order=viewcount&part=snippet&channelId=UCX6OQ3DkcsbYNE6H8uQQuVA&key=AIzaSyAGOQRRzpVRqPtT7hXg1aNW9ffETkGX_tg")
//				.method("GET", null).build();
//		
//		Response response = client.newCall(request).execute();
//		mapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
//
//		videoDTO videoDTO = mapper.readValue(response.body().byteStream(), videoDTO.class);
//		System.out.println(videoDTO.items.get(0));
//		System.out.println(videoDTO.items.get(0).id);
//				Map<String,Object> map = mapper.readValue(response.body().string() , Map.class);
//				System.out.println(map.get("items"));
//				System.out.println(map.get("items.id"));
//				System.out.println(map.get("items[0].id"));
//				System.out.println(map.get("pageInfo"));
//				System.out.println(map.get("pageInfo{0}.totalResults"));
//
		ResponseEntity<VideoDTO> rep = feignRequest.request();
		System.out.println(rep.getBody().kind);
		System.out.println(rep.getBody().etag);
		rep.getBody().items.forEach(item ->{
			System.out.println(item.snippet.title);
		});				
		return "Teste";		 
	}

	@GetMapping("/tasks/{taskId}")
	public String getVideos() {
		return "lista de videos";
	}
}
