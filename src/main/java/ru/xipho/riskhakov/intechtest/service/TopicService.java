package ru.xipho.riskhakov.intechtest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.xipho.riskhakov.intechtest.domain.Role;
import ru.xipho.riskhakov.intechtest.domain.Topic;
import ru.xipho.riskhakov.intechtest.jpa.TopicRepo;

import java.util.Optional;

@Service
public class TopicService {

    private final TopicRepo topicRepo;

    public TopicService(TopicRepo topicRepo) {
        this.topicRepo = topicRepo;
    }

    public Page<Topic> findAllPaginated(Pageable pageable) {
        return topicRepo.findAllByOrderByCreatedAtAsc(pageable);
    }

    public Topic findBySlug(String slug) {
        return topicRepo.findBySlug(slug);
    }

    public Topic findById(Long id) {
        return topicRepo.findById(id).orElse(null);
    }

    public Topic createTopic(Topic topic) {
        String slug = topic.getTitle().toLowerCase()
                .replaceAll("[ ]", "-")
                .replaceAll("[:%,.!&@#$?_/]", "");
        topic.setSlug(slug);
        topic = topicRepo.save(topic);
        return topic;
    }

    public void deleteTopic(Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Topic topic = topicRepo.findById(id).get();

        boolean canDeleteTopic =
                auth.getAuthorities().contains(Role.ADMIN) || auth.getName().equals(topic.getAuthor().getUsername());
        if (topic != null && canDeleteTopic) {
            topicRepo.delete(topic);
        }
    }
}
