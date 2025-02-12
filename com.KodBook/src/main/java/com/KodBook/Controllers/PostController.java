package com.KodBook.Controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.KodBook.Services.PostService;
import com.KodBook.entities.Post;


@Controller
public class PostController {
	@Autowired
	PostService service;
     

	@PostMapping("/createPost")
	public String createdPost(@RequestParam("caption")String caption,
			@RequestParam("photo")MultipartFile photo,
			Model model
			) {
		Post post=new Post();
		post.setCaption(caption);
		try {
			post.setPhoto(photo.getBytes());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		service.createPost(post);
		
		return "Home";
	}
}
