package com.gsilva.blog.service;

import com.gsilva.blog.model.Post;
import com.gsilva.blog.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

	private static final Logger LOG = LoggerFactory.getLogger(PostService.class);

	private final PostRepository postRepository;

	@Autowired
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public List<Post> findAll() {
		return postRepository.findAll();
	}

	public Post findOne(long id) {
		return postRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("O Post não existe"));
	}

	public void save(Post post) {
		LOG.info("Publicando post '{}' por {}", post.getTitulo(), post.getAutor());
		postRepository.save(post);
	}

	public void delete(Long id) {
		Post post = findOne(id);
		LOG.info("Deletando post {}", post.getId());
		postRepository.delete(post);
	}
}
