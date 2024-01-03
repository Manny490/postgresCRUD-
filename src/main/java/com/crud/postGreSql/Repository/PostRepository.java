package com.crud.postGreSql.Repository;

import com.crud.postGreSql.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    // additional query methods can be defined here
}

