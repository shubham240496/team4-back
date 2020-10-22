package com.morningstar.mssearch.web.controller;

import com.morningstar.mssearch.common.response.Response;
import com.morningstar.mssearch.common.response.ResponseCode;
import com.morningstar.mssearch.web.entity.PersonRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author hdeng
 */
@RestController
@RequestMapping("person")
public class UserController {

    private static String USERNAME = "test";
    private static String PASSWORD = "test";

    @PostMapping("login")
    public Response login(@RequestBody PersonRequest personRequest) {
        if (USERNAME.equals(personRequest.getUsername()) && PASSWORD.equals(personRequest.getPassword())) {
            return Response.createBySuccess();
        }
        return Response.createByErrorCode(ResponseCode.LOGIN_ERROR);
    }
}
