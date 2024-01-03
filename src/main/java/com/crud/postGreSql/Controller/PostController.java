package com.crud.postGreSql.Controller;

import com.crud.postGreSql.Entity.Post;
import com.crud.postGreSql.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService service;

    @GetMapping
    public List<Post> getAllPosts() {
        return service.getAllPosts();
    }

    @GetMapping("/{id}")
    public Optional<Post> getPostById(@PathVariable Long id) {
        return service.getPostById(id);
    }

    @PostMapping
    public Post savePost(@RequestBody Post post) {
        return service.savePost(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        service.deletePost(id);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        return service.updatePost(id, updatedPost);
    }
}

