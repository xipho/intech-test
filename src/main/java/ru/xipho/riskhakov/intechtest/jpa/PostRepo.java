package ru.xipho.riskhakov.intechtest.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.xipho.riskhakov.intechtest.dao.Post;

public interface PostRepo extends JpaRepository<Post, Long> {
}
