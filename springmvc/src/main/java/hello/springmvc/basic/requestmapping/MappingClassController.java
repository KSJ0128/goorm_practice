package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {
    @GetMapping("")
    public String getUser() {
        return "get user";
    }

    @PostMapping("")
    public String addUser() {
        return "post user";
    }

    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId) {
        return "get userId=" + userId;
    }


    @PatchMapping("/{userId}")
    public String updateUser() {
        return "update user";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser() {
        return "delete user";
    }
}
