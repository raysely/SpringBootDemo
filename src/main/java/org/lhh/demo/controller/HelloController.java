package org.lhh.demo.controller;

import org.lhh.demo.properties.MemberProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by raysely on 17/7/6.
 */
@RestController
@RequestMapping("/hello")
//@Controller
public class HelloController {

    /**
     * 从yml文件中获取配置的值.
     */
    @Value("${level}")
    private String level;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;

    @Autowired
    private MemberProperties memberProp;

    //@RequestMapping(value = "/say", method = RequestMethod.POST)  //使用post方式后，网面url地址会访问不了，需要使用如postman等工具访问。
    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    //@RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
    //@RequestMapping(value = "/say/{id}", method = RequestMethod.GET) //@PathVariable("id") Integer id
    //@RequestMapping(value = "/{id}/say", method = RequestMethod.GET) //@PathVariable("id") Integer id
    //@RequestMapping(value = "/say", method = RequestMethod.GET)  //@RequestParam("mid") Integer id   mid要等同于url上的参数名
    @GetMapping("/say")  //等同于 @GetMapping(value = "/say")
    @PostMapping("/say")
    public String say(@RequestParam(value = "mid", required = false, defaultValue = "0") Integer id) {
        //return memberProp.getLevel();
        //return content;
        //return "member level is :" + level + " and age is " + age;
        //return "Hello Spring Boot!";
        return "id:" + id;

        //该index指向resources/templates/index.html文件。使用时需要在pom文件中引用Spring-boot-starter-htymeleaf.
        //目前是前后端分离的时代，只要提供前端需要的json数据即可。使用模板对性能有影响。
        //return "index";
    }
}
