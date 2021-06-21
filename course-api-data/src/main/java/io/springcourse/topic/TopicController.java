package io.springcourse.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getTopics() {
        return topicService.getTopics();
    }

    //get topic by id
    @RequestMapping("/topics/{id}")
    public Topic getTopicById(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    //post method to add the topic
    @RequestMapping(method=RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);        
    }

    //put method
    @RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(topic, id);        
    }

    //delete method
    @RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);        
    }
}
