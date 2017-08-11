package org.lhh.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 添加会员.
     * @return member
     */
    @PostMapping(value = "/members")
    public Member memberAdd(@RequestParam("name") String name,
                            @RequestParam("level") String level,
                            @RequestParam("age") Integer age) {
        final Member member = new Member();
        member.setName(name);
        member.setLevel(level);
        member.setAge(age);

        return memberDao.save(member);
    }
}
