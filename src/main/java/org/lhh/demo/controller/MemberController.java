package org.lhh.demo.controller;

import org.lhh.demo.dao.IMemberDao;
import org.lhh.demo.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by raysely on 17/7/30.
 */
@RestController
public class MemberController {

    @Autowired
    private IMemberDao memberDao;

    /**
     * 获取所有会员列表.
     * @return List
     */
    @GetMapping(value = "/members")
    public List<Member> memberList() {
        return memberDao.findAll();
    }

//    /**
//     * 添加会员.
//     * @return member
//     */
//    @PostMapping(value = "/members")
//    public Member memberAdd(@RequestParam("name") String name,
//                            @RequestParam("level") String level,
//                            @RequestParam("age") Integer age) {
//        final Member member = new Member();
//        member.setName(name);
//        member.setLevel(level);
//        member.setAge(age);
//
//        return memberDao.save(member);
//    }

    /**
     * 添加会员.
     * 直接使用对象做为参数，解决参数过多问题。
     * @return member
     */
    @PostMapping(value = "/members")
    public Member memberAdd(@Valid final Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return memberDao.save(member);
    }

    //查询一个会员
    @GetMapping(value = "/members/{id}")
    public Member memberFindOne(@PathVariable("id") Integer id) {
        return memberDao.findOne(id);
    }

    //更新
    @PutMapping(value = "/members/{id}")
    public Member memberUpdate(@PathVariable("id") Integer id,
                             @RequestParam("name") String name,
                             @RequestParam("level") String level,
                             @RequestParam("age") Integer age) {
        final Member member = new Member();
        member.setId(id);
        member.setName(name);
        member.setLevel(level);
        member.setAge(age);
        return memberDao.save(member);
    }

    //删除
    @DeleteMapping(value = "/members/{id}")
    public void memberDelete(@PathVariable("id") Integer id) {
        memberDao.delete(id);
    }

    //通过年龄查询会名列表
    @GetMapping(value = "/members/age/{age}")
    public List<Member> memberListByAge(@PathVariable("age") Integer age) {
        return memberDao.findByAge(age);
    }
}
