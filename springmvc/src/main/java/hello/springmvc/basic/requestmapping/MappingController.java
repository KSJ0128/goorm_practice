package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-basic")
@Slf4j
public class MappingController {
    @GetMapping("")
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    @GetMapping("/{userId}")
    public String mappingPath(@PathVariable String userId) {
        log.info("userId={}", userId);
        return "ok";
    }
}
