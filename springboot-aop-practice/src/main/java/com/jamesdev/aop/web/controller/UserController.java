package com.jamesdev.aop.web.controller;

import com.jamesdev.aop.web.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Scope(value= ConfigurableBeanFactory.SCOPE_SINGLETON)
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/user")
    public ResponseEntity<CommonDto<List<User>>> findAll() {
        System.out.println("findAll()");
        return new ResponseEntity<>(new CommonDto<>(HttpStatus.OK.value(), userRepository.findAll()), HttpStatus.OK); //Message Converter => Java Object -> JSON String
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<CommonDto<User>> findById(@PathVariable int id){
        System.out.println("findById()");
        return new ResponseEntity<>(new CommonDto<>(HttpStatus.OK.value(),userRepository.findById(id)),HttpStatus.OK);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<CommonDto<String>> delete(@PathVariable int id){
        System.out.println("delete()");
        userRepository.delete(id);
        return new ResponseEntity<>(new CommonDto<>(HttpStatus.OK.value(),"OK"),HttpStatus.OK);
    }
    @PostMapping("/user")
    public ResponseEntity<CommonDto<?>> save(@RequestBody @Validated JoinReqDto joinReqDto, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            Map<String, String> errorMap = new HashMap<>();
//            for (FieldError error : bindingResult.getFieldErrors()) {
//                errorMap.put(error.getField(), error.getDefaultMessage());
//                return new ResponseEntity<>(new CommonDto<>(HttpStatus.BAD_REQUEST.value(), errorMap), HttpStatus.BAD_REQUEST);
//            }
//        }
        System.out.println("save()");
        System.out.println("user : "+joinReqDto);
        userRepository.save(joinReqDto);
        return new ResponseEntity<>(new CommonDto<>(HttpStatus.CREATED.value(),joinReqDto),HttpStatus.OK);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<CommonDto<?>> update(@PathVariable int id, @Validated @RequestBody UpdateReqDto updateReqDto, BindingResult bindingResult){

//        if(bindingResult.hasErrors()){
//            Map<String,String> errorMap = new HashMap<>();
//            for(FieldError error:bindingResult.getFieldErrors()){
//                errorMap.put(error.getField(),error.getDefaultMessage());
//                return new ResponseEntity<>(new CommonDto<>(HttpStatus.BAD_REQUEST.value(), errorMap),HttpStatus.BAD_REQUEST);
//            }
//        }
        System.out.println("update()");
        userRepository.update(id,updateReqDto);
        return new ResponseEntity<>(new CommonDto<>(HttpStatus.OK.value(),"OK"),HttpStatus.OK);
    }

    }
