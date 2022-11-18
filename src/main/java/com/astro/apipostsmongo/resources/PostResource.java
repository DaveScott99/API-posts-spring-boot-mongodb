package com.astro.apipostsmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astro.apipostsmongo.domain.Post;
import com.astro.apipostsmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> findByID(@PathVariable String id){
		Post obj = postService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}