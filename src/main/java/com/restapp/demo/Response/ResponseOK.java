package com.restapp.demo.Response;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.OK)
public class ResponseOK extends RuntimeException { }
