package com.KodBook.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.KodBook.entities.Post;

public interface PostRepository extends JpaRepository<Post,Long>{

}
