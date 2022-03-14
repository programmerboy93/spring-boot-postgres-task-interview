package com.example.demo;

import com.example.demo.repo.ExampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleServiceImpl implements ExampleService {

    private final ExampleRepository exampleRepository;

    @Override
    public List<Example> get(String column, String option) {

        if (option.equals("unique")) {
            return exampleRepository.findOnlyUnique(column);
        } else {
            return exampleRepository.findOnlyDuplicate(column);
        }
    }
}
