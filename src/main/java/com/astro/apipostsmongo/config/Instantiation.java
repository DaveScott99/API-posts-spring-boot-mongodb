package com.astro.apipostsmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.astro.apipostsmongo.domain.Post;
import com.astro.apipostsmongo.domain.User;
import com.astro.apipostsmongo.dto.AuthorDTO;
import com.astro.apipostsmongo.repository.PostRepository;
import com.astro.apipostsmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com"); 
		User alex = new User(null, "Alex Green", "alex@gmail.com"); 
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/11/2022"), "Partiu viagem", "Vou viajar para são paulo. Abraços!", new AuthorDTO(maria));
		
		Post post2 = new Post(null, sdf.parse("20/11/2022"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		Post post3 = new Post(null, sdf.parse("19/11/2022"), "Programando", "Criando uma api", new AuthorDTO(bob));
	
		postRepository.saveAll(Arrays.asList(post1, post2, post3));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
	}

}
