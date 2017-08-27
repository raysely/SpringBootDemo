package org.lhh.demo.service;

import org.lhh.demo.dao.IMemberDao;
import org.lhh.demo.domain.Member;
import org.lhh.demo.enums.ResultEnum;
import org.lhh.demo.exception.MemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by raysely on 17/8/13.
 */
@Service
public class MemberService {

    @Autowired
    private IMemberDao memberDao;

    @Transactional
    public void insertTwo() {

    }

    public void getAge(final Integer id) throws Exception {
        final Member member = memberDao.findOne(id);
        final Integer age = member.getAge();
        if (age < 10) {
            //返回"你还在上小学吧"  code=100
            throw new MemberException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            //返回"你可能在上初中" code=101
            throw new MemberException(ResultEnum.MIDDLE_SCHOOL);
        }
    }
}
