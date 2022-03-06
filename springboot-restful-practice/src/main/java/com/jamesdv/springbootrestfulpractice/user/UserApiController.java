package com.jamesdv.springbootrestfulpractice.user;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;






@RestController
public class UserApiController {

    @Autowired
    private UserDaoService userDaoService;

    //retrieveAllUsers
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

    //retrieveUser(int id)
    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        User user=userDaoService.findOne(id);
        System.out.println("user : "+user);
        if(user==null) {
            throw new UserNotFoundException("id-" + id);
        }


        //"all-users", SERVER_PATH + "/users"
        //HATEOAS
        EntityModel<User> resource = EntityModel.of(user);
        WebMvcLinkBuilder linkTo=WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    //CREATED
    //input - details of user
    //output - CREATED, & Return the created URI
    @PostMapping("/users")
    public HttpEntity createUser(@RequestBody @Validated User user){
        User savedUser = userDaoService.save(user);

        //CREATED
        // /user/{id}   savedUser.getId()
        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user=userDaoService.deleteById(id);
        if(user==null) {
            throw new UserNotFoundException("id-" + id);
        }
    }


}
