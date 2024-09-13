package sbcom1.springboot.service;

import org.springframework.web.client.RestClient;
import java.util.*;

import sbcom1.springboot.entity.Post;

public class PostService {
    private final RestClient restclient;
 
    public PostService(){
        this.restclient=RestClient.create();
    }
 
    @SuppressWarnings("unchecked")
    public List<Post> getAllPosts(){
        return restclient.get()
        .uri("http://localhost:9090/person/details")
        .retrieve()
        .body(List.class);
    }
 

    public Post createPost(Post post) {
        return restclient.post()
                .uri("http://localhost:9090/person/add")
                .body(post)
                .retrieve()
                .body(Post.class);
    }
 
    public Post updatePost(int id, Post post) {
        return restclient.put()
                .uri("http://localhost:9090/person/edit/{id}", id)
                .body(post)  
                .retrieve()
                .body(Post.class);
    }
 
    public void deletePost(int id) {
        restclient.delete()
                .uri("http://localhost:9090/person/delete/{id}", id)
                .retrieve()
                .toBodilessEntity();
    
}
}
