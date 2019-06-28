package ru.xipho.riskhakov.intechtest.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.xipho.riskhakov.intechtest.dao.Topic;

public interface TopicRepo extends JpaRepository<Topic, Long> {
    Topic findBySlug(String slug);
}
