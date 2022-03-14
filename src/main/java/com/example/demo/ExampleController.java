package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:63342")
public class ExampleController {

    private final ExampleService exampleService;

    @PostMapping("/examples/{column}/{option}")
    public List<Example> unique(@PathVariable String column, @PathVariable String option) {
        return exampleService.get(column, option);
    }
}
