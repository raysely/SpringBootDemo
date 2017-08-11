package org.lhh.demo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by raysely on 17/8/2.
 */
public interface IMemberDao extends JpaRepository<Member, Integer> {
}
