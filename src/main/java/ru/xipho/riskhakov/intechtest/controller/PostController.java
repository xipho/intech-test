package ru.xipho.riskhakov.intechtest.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.xipho.riskhakov.intechtest.dao.Post;
import ru.xipho.riskhakov.intechtest.dao.Topic;
import ru.xipho.riskhakov.intechtest.dao.User;
import ru.xipho.riskhakov.intechtest.service.PostService;
import ru.xipho.riskhakov.intechtest.service.TopicService;

@Controller
@RequestMapping("/posts")
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class PostController {

    private final PostService postService;
    private final TopicService topicService;

    public PostController(PostService postService, TopicService topicService) {
        this.postService = postService;
        this.topicService = topicService;
    }

    @PostMapping("/{topicId:\\d+}")
    public String addPost(@AuthenticationPrincipal User user,
                          @PathVariable Long topicId, Post post) {

        post.setAuthor(user);
        Topic topic = topicService.findById(topicId);
        post.setTopic(topic);
        Post createdPost = postService.createPost(post);
        return "redirect:/topics/" + topic.getSlug();
    }
}
