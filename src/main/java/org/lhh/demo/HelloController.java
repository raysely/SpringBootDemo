package org.lhh.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by raysely on 17/7/6.
 */
@RestController
public class HelloController {

    @Value("${level}")
    private String level;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;

    @Autowired
    private MemberProperties memberProp;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return memberProp.getLevel();
        //return content;
        //return "member level is :" + level + " and age is " + age;
        //return "Hello Spring Boot!";
    }
}
