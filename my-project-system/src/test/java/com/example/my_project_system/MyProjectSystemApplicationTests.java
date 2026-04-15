package com.example.my_project_system;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyProjectSystemApplicationTests {

	@Test
	void contextLoads() {
	}

}

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String hello() {
        return "Hello from Spring Boot!";
    }
}