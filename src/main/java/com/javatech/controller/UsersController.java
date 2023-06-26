package com.javatech.controller;

        import com.javatech.model.Users;
        import com.javatech.service.UsersService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Users createUser(@RequestBody Users users){
        return service.addTask(users);
    }

    @GetMapping
    public List<Users> getUsers() {
        return service.findAllUsers();
    }


    @GetMapping("/{taskId}")
    public Users getUsers(@PathVariable String userId){
        return service.getUsersByUserId(userId);
    }

    @GetMapping("/severity/{severity}")
    public List<Users> findUsersUsingPriority(@PathVariable int priority){
        return service.getUsersByPriority(priority);
    }

    @GetMapping("/assignee/{assignee}")
    public List<Users> getUsersByDepartment(@PathVariable String department){
        return service.getUsersByDepartment(department);
    }

    @PutMapping
    public Users modifyUsers(@RequestBody Users users){
        return service.updateTask(users);
    }

    @DeleteMapping("/{userId}")
    public String deleteUsers(@PathVariable String userId){
        return service.deleteUsers(userId);
    }
}