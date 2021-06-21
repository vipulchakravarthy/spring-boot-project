package io.springcourse.topic;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

    public List<Topic> getTopics() {
    	List<Topic> list = new ArrayList<>();
    	topicRepository.findAll().forEach(list::add);
    	return list;
    }

    public Topic getTopic(String id){
//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    	return topicRepository.findById(id).orElse(null);
    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id){
        topicRepository.save(topic);
    }

    public void deleteTopic(String id){
        topicRepository.deleteById(id);
    }
}