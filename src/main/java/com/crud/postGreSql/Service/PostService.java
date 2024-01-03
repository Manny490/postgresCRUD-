package com.crud.postGreSql.Service;

import com.crud.postGreSql.Entity.Post;
import com.crud.postGreSql.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public List<Post> getAllPosts() {
        return repository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return repository.findById(id);
    }

    public Post savePost(Post post) {
        return repository.save(post);
    }

    public void deletePost(Long id) {
        repository.deleteById(id);
    }

    public Post updatePost(Long id, Post updatedPost) {
        Optional<Post> optionalPost = repository.findById(id);

        if (optionalPost.isPresent()) {
            Post existingPost = optionalPost.get();
            existingPost.setTitle(updatedPost.getTitle());
            existingPost.setContent(updatedPost.getContent());
            return repository.save(existingPost);
        } else {
            // Handle not found scenario
            return null;
        }
    }
}
