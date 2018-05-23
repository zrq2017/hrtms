package mapper;

import model.Course;
import model.Money;
import model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zrq on 2018-5-19.
 */
public interface AdminMapper {
    public List<Money> findMoney(Money money);
    public Integer updateMoney(Money money);

    public List<User> findUser(@Param("role") String role);

    public Integer saveUser(User user);
    public Integer deleteUser(User user);
}
