package ru.xipho.riskhakov.intechtest.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ru.xipho.riskhakov.intechtest.domain.Post;
import ru.xipho.riskhakov.intechtest.domain.Topic;

import java.util.List;

public interface PostRepo extends CrudRepository<Post, Long> {
    List<Post> findByOrderByCreatedAtAsc();
    Page<Post> findAllByTopicOrderByCreatedAt(Topic topic, Pageable pageable);

}
