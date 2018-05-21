package mapper;

import model.Course;
import model.Score;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zrq on 2018-5-19.
 */
public interface TeacherMapper {
    public Integer save(@Param("id") Integer id,@Param("tid") Integer tid);

    public int delete(Integer id);

    public List<Course> findMyCourse(Integer id);

    public List<Score> findMyStudent(Integer id);

    public Integer updateScore(Score score);
}
