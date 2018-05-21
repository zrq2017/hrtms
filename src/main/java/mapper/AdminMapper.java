package mapper;

import model.Course;
import model.Money;

import java.util.List;

/**
 * Created by zrq on 2018-5-19.
 */
public interface AdminMapper {
    public List<Money> findMoney(Money money);
    public Integer updateMoney(Money money);
}
