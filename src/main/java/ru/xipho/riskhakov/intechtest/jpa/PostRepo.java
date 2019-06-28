package ru.xipho.riskhakov.intechtest.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ru.xipho.riskhakov.intechtest.domain.Post;
import ru.xipho.riskhakov.intechtest.domain.Topic;

public interface PostRepo extends CrudRepository<Post, Long> {
    Page<Post> findAllByTopicOrderByCreatedAt(Topic topic, Pageable pageable);

}
