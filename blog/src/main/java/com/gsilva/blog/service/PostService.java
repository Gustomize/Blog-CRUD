package com.gsilva.blog.service;

import com.gsilva.blog.model.Post;
import com.gsilva.blog.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.text.MessageFormat.format;

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
		Optional<Post> post = postRepository.findById(id);
		return post.orElseThrow(() -> new RuntimeException("O Post não existe"));
	}

	public void save(Post post) {
		LOG.info(format("Publicando post '{0}' por {1}", post.getTitulo(), post.getAutor()));
		postRepository.save(post);
	}

	public void delete(Long id) {
		Post post = findOne(id);
		LOG.info(format("Deletando post {}", post.getId()));
		postRepository.delete(post);
	}
}
