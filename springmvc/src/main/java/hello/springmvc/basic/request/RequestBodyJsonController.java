package hello.springmvc.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.HelloData;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


/**
 * username : hello, age : 20
 * content-type : application/jsonprivate ObjectMapper objectMapper = new ObjectMapper();
 *
 *     @PostMapping("/request-body-json-v1")
 *     public void requestBodyJsonV1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
 *         ServletInputStream inputStream = req.getInputStream();
 *         String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
 *
 *         log.info("messageBody={}",messageBody);
 *         HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
 *         log.info("usernmae={}, age={}", helloData.getUsername(), helloData.getAge());
 *         resp.getWriter().write("ok");
 *     }
 *
 *     @ResponseBody
 *     @PostMapping("/request-body-json-v2")
 *     public String requestBodyJsonV2(@RequestBody String messageBody) throws IOException {
 *         log.info("messageBody={}",messageBody);
 *         HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
 *         log.info("usernmae={}, age={}", helloData.getUsername(), helloData.getAge());
 *         return "ok";
 *     }
 *
 *     @ResponseBody
 *     @PostMapping("/request-body-json-v3")
 *     public String requestBodyJsonV3(@RequestBody HelloData helloData) {
 *         log.info("usernmae={}, age={}", helloData.getUsername(), helloData.getAge());
 *         return "ok";
 *     }
 *
 *     @ResponseBody
 *     @PostMapping("/request-body-json-v4")
 *     public String requestBodyJsonV4(HttpEntity<HelloData> httpEntity) {
 *         HelloData data = httpEntity.getBody();
 *         log.info("usernmae={}, age={}", data.getUsername(), data.getAge());
 *         return "ok";
 *     }
 *
 *     @ResponseBody
 *     @PostMapping("/request-body-json-v5")
 *     public HelloData requestBodyJsonV5(@RequestBody HelloData helloData) {
 *         log.info("usernmae={}, age={}", helloData.getUsername(), helloData.getAge());
 *         return helloData;
 *     }
 */
@Slf4j
@Controller
public class RequestBodyJsonController {

}
