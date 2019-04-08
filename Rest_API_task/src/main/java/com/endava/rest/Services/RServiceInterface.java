package com.endava.rest.Services;

import com.endava.rest.models.Issue;

public interface RServiceInterface {

    String getAllTasksByUsername(String user);

    String getTaskById(int id);

    void createIssue(Issue issue);


    void update(int id, Issue issue);


}
