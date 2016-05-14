package org.jakubd.filtering.repository;

import org.jakubd.filtering.domain.Post;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer>, QueryDslPredicateExecutor<Post> {
}
