package org.lhh.demo.dao;

import org.lhh.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by raysely on 17/8/2.
 */
public interface IMemberDao extends JpaRepository<Member, Integer> {

    //通过年龄来查询
    public List<Member> findByAge(Integer age);
}
