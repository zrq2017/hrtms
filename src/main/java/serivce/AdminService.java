package serivce;

import mapper.AdminMapper;
import mapper.CourseMapper;
import model.Course;
import model.Money;
import model.Score;
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
    @Autowired
    private AdminMapper adminMapper;
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

    public Integer addCourse(Course course) {
        return courseMapper.save(course);
    }

    public Integer updateCourse(Course course) {
        return courseMapper.update(course);
    }

    public List<Score> findScore(Course course) {
        return courseMapper.findScoreByConditions(course);
    }

    public List<Money> findMoney(Money money) {
        return adminMapper.findMoney(money);
    }

    public Integer updateMoney(Money money) {
        return adminMapper.updateMoney(money);
    }
}
