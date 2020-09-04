package com.bookcatlog.bookcatlog.controller;

import com.bookcatlog.bookcatlog.pojos.BaseResponse;
import com.bookcatlog.bookcatlog.pojos.requests.ReqUser;
import com.bookcatlog.bookcatlog.pojos.responses.ResUser;
import com.bookcatlog.bookcatlog.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/v1/")
public class UserController {
    private  final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/createUser",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<ResUser>> createUser(@RequestBody ReqUser reqUser)  {
        return new ResponseEntity<>(
                new BaseResponse<>(
                        "success",
                        userService.createUser(reqUser)
                        ),
                HttpStatus.OK
        );
    }
}

