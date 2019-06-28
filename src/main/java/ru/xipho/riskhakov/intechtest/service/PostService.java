package ru.xipho.riskhakov.intechtest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.xipho.riskhakov.intechtest.domain.Post;
import ru.xipho.riskhakov.intechtest.domain.Role;
import ru.xipho.riskhakov.intechtest.domain.Topic;
import ru.xipho.riskhakov.intechtest.jpa.PostRepo;

import java.util.Optional;

@Service
public class PostService {

    private final PostRepo postRepo;

    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public Page<Post> loadPaginatedPosts(Topic topic, Pageable pageable) {
        return postRepo.findAllByTopicOrderByCreatedAt(topic, pageable);
    }

    public Post createPost(Post post) {
        return postRepo.save(post);
    }

    public String deletePost(long postId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<Post> postOptional = postRepo.findById(postId);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            Topic topic = post.getTopic();
            boolean canDeletePost =
                    auth.getAuthorities().contains(Role.ADMIN) || auth.getName().equals(post.getAuthor().getUsername());
            if (canDeletePost) {
                postRepo.delete(post);
            }
            return topic.getSlug();
        } else {
            return null;
        }
    }
}
