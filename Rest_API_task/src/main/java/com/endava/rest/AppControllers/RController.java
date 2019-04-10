package com.endava.rest.AppControllers;

import com.endava.rest.Services.RServiceInterface;
import com.endava.rest.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
@PropertySource("classpath:application.properties")
public class RController {


    @Autowired
    RServiceInterface rSerrvice;


    /*Authorize*/
    @GetMapping("/authentificate")
    public ResponseEntity<?> authentificate(@RequestHeader(value = "Authorization") HttpHeaders httpHeaders ) {

        rSerrvice.getToken();
        rSerrvice.setHttpHeaders(httpHeaders);
        System.err.println(httpHeaders.values());

        return new ResponseEntity<>(HttpStatus.OK);
    }
    /*Get task by username*/
    @GetMapping("/getTask")
    public ResponseEntity<String> getAllTasksByUsername(@RequestParam String user) {

        return rSerrvice.getAllTasksByUsername(user);
    }

    /*Get task by ID*/
    @GetMapping("/getTask/{id}")
    private ResponseEntity<String> getEmployees(@PathVariable int id) {
        return rSerrvice.getTaskById(id);
    }

    /*Create a issue*/
    @RequestMapping(value = "/createIssue", method = RequestMethod.POST)
    public void createEmployee(@RequestBody Issue issue) {
        rSerrvice.createIssue(issue);
    }

    /*Update By Id*/
    @PutMapping("/updateTask/{id}")
    public void update(@PathVariable int id, @RequestBody Issue issue) {
        rSerrvice.update(id, issue);
    }


}
