package com.example.demo.repo;

import com.example.demo.Example;

import java.util.List;


public interface ExampleRepository {

    List<Example> findOnlyUnique(String column);

    List<Example> findOnlyDuplicate(String column);
}
