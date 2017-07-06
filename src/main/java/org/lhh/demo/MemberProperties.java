package org.lhh.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by raysely on 17/7/6.
 *
 * 把配置文件注入到一个对象中。
 * 加上ConfigurationProperties注解后，会自动匹配application.yml中的属性。
 */
@Component
@ConfigurationProperties(prefix = "member")
public class MemberProperties {
    private String level;
    private Integer age;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
