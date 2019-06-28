package ru.xipho.riskhakov.intechtest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.xipho.riskhakov.intechtest.domain.Post;
import ru.xipho.riskhakov.intechtest.domain.Topic;
import ru.xipho.riskhakov.intechtest.jpa.PostRepo;

import java.util.List;

@Service
public class PostService {

    private final PostRepo postRepo;

    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public List<Post> loadPosts() {
        return postRepo.findByOrderByCreatedAtAsc();
    }

    public Page<Post> loadPaginatedPosts(Topic topic, Pageable pageable) {
        return postRepo.findAllByTopicOrderByCreatedAt(topic, pageable);
    }

    public Post createPost(Post post) {
        return postRepo.save(post);
    }
}
