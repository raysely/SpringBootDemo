package org.lhh.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * Created by raysely on 17/7/29.
 */
@Entity
public class Member {

    /**
     * 构造方法（@Entity需要一个无参构造方法）.
     */
    public Member() {
    }

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Min(value = 3, message = "不满三周岁儿童不能添加。")
    private Integer age;

    private String level;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", level='" + level + '\'' +
                '}';
    }
}
