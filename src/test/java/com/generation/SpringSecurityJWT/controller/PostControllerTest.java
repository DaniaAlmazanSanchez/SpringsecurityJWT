package com.generation.SpringSecurityJWT.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.generation.SpringSecurityJWT.model.Post;
import com.generation.SpringSecurityJWT.service.PostService;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.api.DisplayName;

import org.springframework.security.core.parameters.P;

class PostControllerTest {
 @Test
    @DisplayName("probando mockito")
    void testMockito() {
     //mock creation
     List mockedList = mock(List.class);
     //using mock oject
     mockedList.add("one");
     mockedList.clear();
     //verification
     verify(mockedList).add("one");
     verify(mockedList).clear();
 }
 @Test
 @DisplayName("pruebas post")
 void postSaveTest(){
         PostService postService = mock(PostService.class);
         PostController postController = new PostController(postService);

         Post post = new Post();
         post.setTitle("pruebas en Junit con mockito");
         post.setContent("contenido post");
         when(postService.save(any(Post.class))).thenReturn(post);

         Post result = postController.save(post);
         verify(postService, times(1)).save(any(Post.class));
         assertEquals(post.getTitle(),result.getTitle());

 }

 }
