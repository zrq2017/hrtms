package serivce;

import mapper.AdminMapper;
import mapper.CourseMapper;
import mapper.TeacherMapper;
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
public class TeacherService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    /**
     * 返回所有课程信息
     * @return
     */
    public List<Course> findAll() {
        return courseMapper.findAll();
    }

    public int deleteCourse(Integer id) {
        return teacherMapper.delete(id);
    }

    public Integer chooseCourse(Integer id,Integer tid) {
        return teacherMapper.save(id,tid);
    }

    public List<Course> findMyCourse(Integer id) {
        return teacherMapper.findMyCourse(id);
    }

    public List<Score> findMyStudent(Integer id) {
        return teacherMapper.findMyStudent(id);
    }

    public Integer updateScore(Score score) {
        return teacherMapper.updateScore(score);
    }
}
