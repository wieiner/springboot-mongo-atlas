package com.javatech.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    private String userId;
    private String login;
    private String name;
    private String department;
    private int priority;
}
