package com.rest.springboot.suhail_springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.springboot.suhail_springboot.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
