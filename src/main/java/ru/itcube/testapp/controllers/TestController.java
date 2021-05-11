package ru.itcube.testapp.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itcube.testapp.model.Test;
import ru.itcube.testapp.services.TestService;

@RestController
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(value = "/tests", produces = "application/json")
    public List<Test> listTests() {
        return testService.listAllTests();
    }
}
