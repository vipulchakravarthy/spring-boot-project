package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(new Topic("14", "Spring course", "This is my description"),
            new Topic("126", "Reactnative", "This is my course"), new Topic("128", "Java", "This is my description")));

    public List<Topic> getTopics() {
        return topics;
    }

    public Topic getTopic(String id){
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }
}