package ru.xipho.riskhakov.intechtest.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ru.xipho.riskhakov.intechtest.domain.Topic;

public interface TopicRepo extends CrudRepository<Topic, Long> {
    Page<Topic> findAllByOrderByCreatedAtAsc(Pageable pageable);
    Topic findBySlug(String slug);
}
