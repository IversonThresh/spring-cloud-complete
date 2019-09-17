package com.springboot.jpademo.dao;

import com.springboot.jpademo.entity.Boss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BossRepositiory extends JpaRepository<Boss,Integer> {

}
