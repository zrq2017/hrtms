package model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by zrq on 2018-5-19.
 */
public class Money {
    private Integer id;
    private Course course;
    private User teacher;
    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
