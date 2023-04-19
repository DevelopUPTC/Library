package com.example.demo.controllers;

import com.example.demo.entityes.Author;
import com.example.demo.response.ResponseHandler;
import com.example.demo.services.ServiceAuthor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class ControllerAuthor {

    private ServiceAuthor serviceAuthor;

    public ControllerAuthor(ServiceAuthor serviceAuthor) {
        this.serviceAuthor = serviceAuthor;
    }

    @GetMapping
    public ResponseEntity<Object> findAll(){

        try{
            List<Author> result = serviceAuthor.findAll();

            return new ResponseHandler().generateResponse("Success Completed!", HttpStatus.OK,result);
        }catch(Exception e ){

            return new ResponseHandler().generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Author author ){
        try{
            Author result = serviceAuthor.save( author );

            return new ResponseHandler().generateResponse("Success Completed!", HttpStatus.OK,result);
        }catch(Exception e ){

            return new ResponseHandler().generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id){
        try{
            Author result = serviceAuthor.findById( id );

            return new ResponseHandler().generateResponse("Success Completed!", HttpStatus.OK,result);
        }catch(Exception e ){

            return new ResponseHandler().generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

}
