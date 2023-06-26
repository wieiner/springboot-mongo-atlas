package com.javatech.repository;

import com.javatech.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UsersRepository extends MongoRepository<Users, String> {
    List<Users> findByPriority(int priority);

    @Query("{ department: ?0 }")
    List<Users> getUsersByDepartment(String department);
}
