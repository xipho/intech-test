package ru.xipho.riskhakov.intechtest.controller;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import ru.xipho.riskhakov.intechtest.domain.Post;
import ru.xipho.riskhakov.intechtest.domain.Topic;
import ru.xipho.riskhakov.intechtest.domain.User;
import ru.xipho.riskhakov.intechtest.service.PostService;
import ru.xipho.riskhakov.intechtest.service.TopicService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
                          @PathVariable Long topicId, Post post) throws UnsupportedEncodingException {
        post.setAuthor(user);
        Topic topic = topicService.findById(topicId);
        if(topic == null) return "redirect:/topics";
        post.setTopic(topic);
        Post createdPost = postService.createPost(post);
        return "redirect:/topics/" + URLEncoder.encode(topic.getSlug(), "UTF-8");
    }

    @PostMapping("/delete/{postId:\\d+}")
    public String deletePost(@PathVariable long postId) throws UnsupportedEncodingException {
        String topicSlug = postService.deletePost(postId);
        return "redirect:/topics/" + URLEncoder.encode(topicSlug, "UTF-8");
    }
}
