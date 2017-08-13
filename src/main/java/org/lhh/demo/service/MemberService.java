package org.lhh.demo.service;

import org.lhh.demo.dao.IMemberDao;
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
}
