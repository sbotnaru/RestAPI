package com.endava.rest.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Field {

    private Project project;
    private String summary;
    private String description;
    private Issuetype issuetype;
    private String[] labels;
    private Assignee assignee;


}
