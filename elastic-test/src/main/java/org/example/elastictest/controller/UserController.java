package org.example.elastictest.controller;

import lombok.RequiredArgsConstructor;
import org.example.elastictest.document.UserDocument;
import org.example.elastictest.service.UserSearchService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserSearchService userSearchService;

    @GetMapping("/{user_name}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDocument> findUser(@PathVariable("user_name") String userName){
        return userSearchService.searchName(userName);
    }
}
