package com.endava.rest.Services;

import com.endava.rest.models.Issue;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public interface RServiceInterface {

    HttpHeaders getToken();
    void setHttpHeaders(HttpHeaders httpHeaders);
    ResponseEntity<String> getAllTasksByUsername(String user);

    ResponseEntity<String> getTaskById(int id);

    void createIssue(Issue issue);


    void update(int id, Issue issue);


}
