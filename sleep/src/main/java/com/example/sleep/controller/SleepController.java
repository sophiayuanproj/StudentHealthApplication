package com.example.sleep.controller;

import com.example.sleep.binder.SleepRequestBinder;
import com.example.sleep.model.SleepModel;
import com.example.sleep.repository.SleepRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/sleep")
public class SleepController {
    @Autowired
    private SleepRepository sleepRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

//    @PostMapping(path = "/add")
//    public ResponseEntity addSleep(@RequestBody SleepRequestBinder sleepRequestBinder) {
//        try {
//
//        }
//    }

    @PostMapping(path = "/add-test")
    public @ResponseBody String addSleep(@RequestParam String feel) {
        SleepModel sleep = new SleepModel();
        sleep.setFeel(SleepModel.Feel.NEUTRAL);
        sleepRepository.save(sleep);
        return "Saved";
    }

    @GetMapping("/get-test")
    public @ResponseBody Iterable<SleepModel> getAllSleeps() {
        return sleepRepository.findAll();
    }

}
