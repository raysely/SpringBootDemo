package org.lhh.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lhh.demo.domain.Member;
import org.lhh.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by raysely on 17/8/27.
 */
@RunWith(SpringRunner.class) //底层使用junit
@SpringBootTest //表示将起动整个spring工程
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void findOneTest() {
        final Member member = memberService.findOne(2);
        Assert.assertEquals(new Integer(7), member.getAge());
    }
}
