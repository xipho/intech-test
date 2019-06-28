package ru.xipho.riskhakov.intechtest.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.xipho.riskhakov.intechtest.dao.Topic;
import ru.xipho.riskhakov.intechtest.dao.User;
import ru.xipho.riskhakov.intechtest.service.TopicService;

import java.util.List;

@Controller
@RequestMapping("/topics")
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class TopicController {

    private TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("")
    public String topicList(Model model) {
        List<Topic> topics = topicService.findAll();
        model.addAttribute("topics", topics);
        return "topicList";
    }

    @GetMapping("/{slug:[a-zа-я-]+}")
    public String viewTopic(@PathVariable String slug, Model model) {
        Topic topic = topicService.findBySlug(slug);
        model.addAttribute("topic", topic);
        return "topicView";
    }

    @GetMapping("/add")
    public String addTopic() {
        return "topicAdd";
    }

    @PostMapping("")
    public String addTopic(@AuthenticationPrincipal User user, Topic topic) {
        topic.setAuthor(user);
        topicService.createTopic(topic);
        return "redirect:/topics";
    }
}
