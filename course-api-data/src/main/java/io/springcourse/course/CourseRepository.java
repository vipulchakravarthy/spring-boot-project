package io.springcourse.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface CourseRepository extends CrudRepository<Course, String>{

	//method for get all courses
	public List<Course> findByName(String name);
	
	public List<Course> findByDescription(String description);
	
	public List<Course> findByTopicId(String topicId);
	
}
