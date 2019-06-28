package ru.xipho.riskhakov.intechtest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.xipho.riskhakov.intechtest.domain.Topic;
import ru.xipho.riskhakov.intechtest.jpa.TopicRepo;

import java.util.List;

@Service
public class TopicService {

    private TopicRepo topicRepo;

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
        return topicRepo.findById(id).get();
    }

    public Topic createTopic(Topic topic) {
        String slug = topic.getTitle().toLowerCase().replaceAll("[ :_/]", "-");
        topic.setSlug(slug);
        topic = topicRepo.save(topic);
        return topic;
    }

    public Topic updateTopic(Topic topic) {
        Topic dbTopic = findBySlug(topic.getSlug());
        if (dbTopic != null) {
            topic = topicRepo.save(topic);
        }
        return topic;
    }

    public void deleteTopic(Long id) {

    }
}
