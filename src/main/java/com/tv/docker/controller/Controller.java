package com.tv.docker.controller;

import com.tv.docker.model.*;
import com.tv.docker.service.ServiceClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tarunvishwakarma81
 * The Controller class acts as a RESTful API controller that handles HTTP requests and responses.
 * It defines endpoints for various operations. path associated <IP>:<port>/docker/<any Service>
 */
@RestController
@RequestMapping("/docker")
public class Controller {

    /**
     * The ServiceClass class provides methods to perform different actions on execution od different API.
     */
    ServiceClass service = new ServiceClass();

    /**
     * This method returns a string representation of the demo page.
     *
     * @return a string representation of the demo page
     */
    @GetMapping("/")
    public String demo(){
        return "<h1>Working</h1>";
    }

    /**
     * Returns a string representation of the "Hello World" message.
     *
     * @return the "Hello World" message as a string
     */
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    /**
     * Retrieves a Person object.
     *
     * @return the Person object
     */
    @GetMapping("/person")
    public Person getPerson(){
        return new Person("Tarun", "23");
    }

    /**
     * Retrieves a list of available sort types.
     *
     * @return a List of Strings representing the available sort types
     */
    @GetMapping("/sortTypes")
    public List<String> sortTypes(){
        return service.sortType();
    }

    /**
     * Retrieves a list of available search types.
     *
     * @return a List of Strings representing the available search types
     */
    @GetMapping("/searchTypes")
    public List<String> searchTypes(){
        return service.searchTypes();
    }

    /**
     * Sorts the input list of integers based on the specified sort type.
     *
     * @param sortPayload a {@link SortPayload} object containing the list of integers to be sorted and the sort type
     * @return a {@link ResponseEntity} object containing a {@link SortResponse} object with the sorted list and response status
     * @throws Exception if an error occurs during the sorting process
     */
    @PostMapping("/sort")
    public ResponseEntity<SortResponse> sortRes(@RequestBody SortPayload sortPayload)throws Exception {
        try{
            return new ResponseEntity<>(service.sortResponse(sortPayload.getSortArr(), sortPayload.getSortType()),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new SortResponse(null, new Response("Error", 500,e.toString())),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Searches for a list of strings based on the specified search type.
     *
     * @param stringSearchPayload a {@link StringSearchPayload} object containing the list of String to be searched on and match with pattern and search type
     * @return a {@link ResponseEntity} object containing a {@link StringSearchResponse} object with the searched list and response status
     * @throws Exception if an error occurs during the sorting process
     */
    @PostMapping("/search")
    public ResponseEntity<StringSearchResponse> searchRes(@RequestBody StringSearchPayload stringSearchPayload) throws Exception{
        try{
            return new ResponseEntity<>(service.searchString(stringSearchPayload.getSearchStrList(),stringSearchPayload.getMatchPattern(),stringSearchPayload.getSearchType()),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new StringSearchResponse(0,null,null,null, new Response("Error",500,e.toString())),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
