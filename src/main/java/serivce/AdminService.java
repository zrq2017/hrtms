package serivce;

import mapper.CourseMapper;
import model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zrq on 2018-5-19.
 */
@Service
public class AdminService {
    @Autowired
    private CourseMapper courseMapper;
    /**
     * 返回所有课程信息
     * @return
     */
    public List<Course> findAll() {
        return courseMapper.findAll();
    }

    public int deleteCourse(Integer id) {
        return courseMapper.delete(id);
    }
}
