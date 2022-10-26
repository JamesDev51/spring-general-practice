package com.jamesdev.springbootaoppractice.domain;

import io.sentry.Sentry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public List<User> findAll(){
        List<User> users = new ArrayList<>();
        users.add(new User(1,"ssar","1234","0101111"));
        users.add(new User(2,"cos","1234","0101111"));
        users.add(new User(3,"james","1234","0101111"));
        users.add(new User(4,"love","1234","0101111"));
        return users;
    }
    public User findById(int id){
        return new User(1,"ssar","1234","0101111");
    }

    public void save(JoinReqDto joinReqDto){
        System.out.println("DB에 insert 하기 : "+joinReqDto);
    }
    public void delete(int id){
        System.out.println("DB에 삭제하기");
    }
    public void update(int id, UpdateReqDto updateReqDto){
        try{
            throw new IllegalArgumentException("요청 잘못함");
        }catch(Exception e){
            Sentry.captureException(e);

        }
//        System.out.println("DB 에 수정하기");
    }
}
