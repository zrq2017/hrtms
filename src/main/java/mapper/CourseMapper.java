package mapper;

import model.Course;

import java.util.List;

/**
 * Created by zrq on 2018-5-19.
 */
public interface CourseMapper {
    public List<Course> findAll();
    public List<Course> findByConditions(Course course);
    public void save(Course Course);
    public void update(Course Course);
    public int delete(int id);
}
