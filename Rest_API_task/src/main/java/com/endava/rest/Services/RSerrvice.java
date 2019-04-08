package com.endava.rest.Services;

import com.endava.rest.models.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Service
public class RSerrvice implements RServiceInterface {

    @Autowired
    RestTemplate restTemplate;
    @Value("${r.addres}")
    public  String REST_SERVICE_URI;

    @Value("${s.username}")
    private String username;

    @Value("${s.password}")
    private String password;


    public String getAllTasksByUsername(String user) {
         String uri = REST_SERVICE_URI + "rest/api/2/search?jql=project=\"IIA\"AND assignee =" + "\"" + user + "\"";
        System.out.println(uri);
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(username, password));
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }


    public String getTaskById(int id) {
         String uri = REST_SERVICE_URI + "rest/api/2/issue/" + id;
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(username, password));
        String result = restTemplate.getForObject(uri, String.class);

        return result;
    }


    public void createIssue(Issue issue) {
         String uri = REST_SERVICE_URI + "/rest/api/2/issue";
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(username, password));
        Issue result = restTemplate.postForObject(uri, issue, Issue.class);

        System.out.println(result);

    }


    public void update(int id, Issue issue) {
        String uri = REST_SERVICE_URI + "rest/api/2/issue/" + id;
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(username, password));
        restTemplate.put(uri, issue, Issue.class);
    }


}
