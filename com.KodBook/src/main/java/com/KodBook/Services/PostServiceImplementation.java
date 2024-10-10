package com.KodBook.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KodBook.Repositories.PostRepository;
import com.KodBook.entities.Post;

@Service
public class PostServiceImplementation implements PostService {
	
	@Autowired
	PostRepository repo;
	
	@Override
	public void createPost(Post post) {
		repo.save(post);
	}

}
