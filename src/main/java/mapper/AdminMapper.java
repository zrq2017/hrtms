package mapper;

import model.Course;

import java.util.List;

/**
 * Created by zrq on 2018-5-19.
 */
public interface AdminMapper {
    public List<Course> findCourse();
}
