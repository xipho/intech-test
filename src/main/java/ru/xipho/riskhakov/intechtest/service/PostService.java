package ru.xipho.riskhakov.intechtest.service;

import org.springframework.stereotype.Service;
import ru.xipho.riskhakov.intechtest.dao.Post;
import ru.xipho.riskhakov.intechtest.jpa.PostRepo;

import java.util.List;

@Service
public class PostService {

    private final PostRepo postRepo;

    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public List<Post> loadPosts() {
        return postRepo.findAll();
    }

    public Post createPost(Post post) {
        return postRepo.save(post);
    }
}
