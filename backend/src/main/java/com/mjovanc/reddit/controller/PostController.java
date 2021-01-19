package com.mjovanc.reddit.controller;

import com.mjovanc.reddit.model.Post;
import com.mjovanc.reddit.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @PostMapping("add")
    public String addPost(@RequestParam(value = "bodyContent") String body,
                          @RequestParam(value = "subreddit") String subreddit) {
        Post post = new Post();
        post.setBody(body);
        post.setSubreddit(subreddit);
        postRepository.save(post);
        return "Post has successfully been added to the repo!";
    }

    @GetMapping("list")
    public Iterable<Post> getAllPosts() {
        return this.postRepository.findAll();
    }

    @GetMapping("{id}")
    public Post getPostWithId(@PathVariable Integer id) {
        return this.postRepository.findPostById(id);
    }
}
