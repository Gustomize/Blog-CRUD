package com.gsilva.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsilva.blog.model.Post;
import com.gsilva.blog.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;

	public List<Post> findAll() {
		return postRepository.findAll();
	}

	public Post findOne(long id) {
		return postRepository.findById(id).get();
	}

	public Post save(Post post) {
		return postRepository.saveAndFlush(post);
	}

	public void delete(Long id) {
		postRepository.deleteById(id);
	}
}
