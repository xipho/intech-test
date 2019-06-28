package ru.xipho.riskhakov.intechtest.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.xipho.riskhakov.intechtest.domain.Post;
import ru.xipho.riskhakov.intechtest.domain.Topic;
import ru.xipho.riskhakov.intechtest.domain.User;
import ru.xipho.riskhakov.intechtest.service.PostService;
import ru.xipho.riskhakov.intechtest.service.TopicService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/topics")
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class TopicController {

    private final TopicService topicService;
    private final PostService postService;

    public TopicController(TopicService topicService, PostService postService) {
        this.topicService = topicService;
        this.postService = postService;
    }

    @GetMapping("")
    public String topicList(Model model, @RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "5") int size) {
        Page<Topic> topics = topicService.findAllPaginated(PageRequest.of(page-1, size));
        model.addAttribute("topics", topics);
        return "topicList";
    }

    @GetMapping("/{slug:[a-zа-я-]+}")
    public String viewTopic(@PathVariable String slug, Model model,
                            @RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "3") int size) throws UnsupportedEncodingException {
        Topic topic = topicService.findBySlug(slug);
        String url = "/topics/" + URLEncoder.encode(slug, "UTF-8");
        Page<Post> posts = postService.loadPaginatedPosts(topic, PageRequest.of(page-1, size));
        model.addAttribute("topic", topic);
        model.addAttribute("page", posts);
        model.addAttribute("url", url);
        return "topicView";
    }

    @GetMapping("/add")
    public String addTopic() {
        return "topicAdd";
    }

    @PostMapping("")
    public String addTopic(@AuthenticationPrincipal User user, Topic topic) throws UnsupportedEncodingException {
        topic.setAuthor(user);
        topic = topicService.createTopic(topic);
        return "redirect:/topics/" + URLEncoder.encode(topic.getSlug(), "UTF-8");
    }

    @PostMapping("/{id:\\d+}/delete")
    public String deleteTopic(@PathVariable long id) {
        topicService.deleteTopic(id);
        return "redirect:/topics";
    }
}
