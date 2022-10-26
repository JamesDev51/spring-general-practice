package com.jamesdev.springbootaoppractice.web;

import com.jamesdev.springbootaoppractice.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    //http://localhost:8080/user
    @GetMapping("/user")
    public ResponseEntity<CommonDto<List<User>>> findAll() {
        System.out.println("findAll()");
        return new ResponseEntity<>(new CommonDto<>(HttpStatus.OK.value(), userRepository.findAll()), HttpStatus.OK); //Message Converter => Java Object -> JSON String
    }

    //http://localhost:8080/user/{id}
    @GetMapping("/user/{id}")
    public ResponseEntity<CommonDto<User>> findById(@PathVariable int id){
        System.out.println("findById()");
        return new ResponseEntity<>(new CommonDto<>(HttpStatus.OK.value(),userRepository.findById(id)),HttpStatus.OK);
    }

    //http://localhost:8080/user/
    @PostMapping("/user")
    // x-www-form-urlencoded => request.getParameter()
    //text/plain => @RequestBody 어노테이션
    //application/json => @ResponseBody 어노테이션 + 오브젝트로 받기
    public ResponseEntity<CommonDto<?>> save(@RequestBody @Validated JoinReqDto joinReqDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = new HashMap<>();
            for(FieldError error:bindingResult.getFieldErrors()){
                errorMap.put(error.getField(),error.getDefaultMessage());
                return new ResponseEntity<>(new CommonDto<>(HttpStatus.BAD_REQUEST.value(), errorMap),HttpStatus.BAD_REQUEST);
            }
        }
        System.out.println("save()");
        System.out.println("user : "+joinReqDto);
        userRepository.save(joinReqDto);

//        System.out.println("data : "+data);
//        System.out.println("username : "+username);
//        System.out.println("password : "+password);
//        System.out.println("phone : "+phone);

        return new ResponseEntity<>(new CommonDto<>(HttpStatus.CREATED.value(),joinReqDto),HttpStatus.OK);
    }

    //http://localhost:8080/user/{id}
    @DeleteMapping("/user/{id}")
    public ResponseEntity<CommonDto<String>> delete(@PathVariable int id){
        System.out.println("delete()");
        return new ResponseEntity<>(new CommonDto<>(HttpStatus.OK.value(),"OK"),HttpStatus.OK);
    }

    //http://localhost:8080/user/{id}
    @PutMapping("/user/{id}")
    public ResponseEntity<CommonDto<?>> update(@PathVariable int id, @Validated @RequestBody UpdateReqDto updateReqDto,BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = new HashMap<>();
            for(FieldError error:bindingResult.getFieldErrors()){
                errorMap.put(error.getField(),error.getDefaultMessage());
                return new ResponseEntity<>(new CommonDto<>(HttpStatus.BAD_REQUEST.value(), errorMap),HttpStatus.BAD_REQUEST);
            }
        }

        System.out.println("update()");
        userRepository.update(id,updateReqDto);
        return new ResponseEntity<>(new CommonDto<>(HttpStatus.OK.value(),"OK"),HttpStatus.OK);
    }
}
