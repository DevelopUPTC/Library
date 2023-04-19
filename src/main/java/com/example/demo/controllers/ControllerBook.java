package com.example.demo.controllers;

import com.example.demo.entityes.Book;
import com.example.demo.response.ResponseHandler;
import com.example.demo.services.ServiceAuthor;
import com.example.demo.services.ServiceBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")

public class ControllerBook {
    private ServiceBook serviceBook;

    @Autowired
    private ServiceAuthor serviceAuthor;

    public ControllerBook(ServiceBook serviceBook) {
        this.serviceBook = serviceBook;
    }

    @GetMapping
    public ResponseEntity<Object> getBooks(){

        try{
            List<Book> result = serviceBook.findAll();

            return new ResponseHandler().generateResponse("Success Completed!",HttpStatus.OK,result);
        }catch( Exception e ){
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id){

        try{
            Book result = serviceBook.findById( id );

            return new ResponseHandler().generateResponse("Success Completed!",HttpStatus.OK,result);
        }catch( Exception e ){
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> save( @RequestBody Book book, @PathVariable Integer id ){
        if( serviceAuthor.findById( id ) != null ){
            try{
                Book result = serviceBook.save( book, id);

                return new ResponseHandler().generateResponse("Success Completed!",HttpStatus.OK,result);
            }catch(Exception e){
                return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,null);
            }
        }

        return new ResponseHandler().generateResponse("Fail Author not Found", HttpStatus.NOT_ACCEPTABLE,null);

    }

}
