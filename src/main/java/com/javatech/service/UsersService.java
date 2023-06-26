package com.javatech.service;

import com.javatech.model.Users;
import com.javatech.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsersService {

    @Autowired
    private UsersRepository repository;

    //CRUD CREATE, READ, UPDATE, DELETE

    public Users addTask(Users users)
    {
        users.setUserId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(users);
    }

    public List<Users> findAllUsers() {
        return repository.findAll();
    }

    public Users getUsersByUserId(String userId){
        return repository.findById(userId).get();
    }

    public List<Users> getUsersByPriority(int priority){
        return  repository.findByPriority(priority);
    }

    public List<Users> getUsersByDepartment(String department){
        return repository.getUsersByDepartment(department);
    }

    public Users updateTask(Users usersRequest){
        //get the existing document from DB
        // populate new value from request to existing object/entity/document
        Users existingUsers = repository.findById(usersRequest.getUserId()).get();
        existingUsers.setLogin(usersRequest.getLogin());
        existingUsers.setName(usersRequest.getName());
        existingUsers.setDepartment(usersRequest.getDepartment());
        existingUsers.setPriority(usersRequest.getPriority());
        return repository.save(existingUsers);
    }

    public String deleteUsers(String usersId){
        repository.deleteById(usersId);
        return usersId+"  user deleted from list ";
    }


}
