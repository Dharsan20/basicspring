package sbcom1.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sbcom1.springboot.entity.Post;
import sbcom1.springboot.service.PostService;
import java.util.*;

@RestController
@RequestMapping("/api")
public class PostController {
   
    @Autowired
    private PostService postservice;
 
    @GetMapping("/get")
    public List<Post> getAllPost(){
        return postservice.getAllPosts();
    }
     
    @PostMapping("/post")
    public Post createPost(@RequestBody Post post) {
        return postservice.createPost(post);
    }
 
    @PutMapping("/update/{id}")
    public Post updatePerson(@PathVariable int id, @RequestBody Post post) {
        return postservice.updatePost(id, post);
    }
 
    // DELETE request to delete a Person by id
    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable int id) {
        postservice.deletePost(id);
    }
   
}