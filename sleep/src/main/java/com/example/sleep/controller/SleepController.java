package com.example.sleep.controller;

import com.example.sleep.binder.SleepRequestBinder;
import com.example.sleep.model.SleepModel;
import com.example.sleep.repository.SleepRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping(path = "/sleep")
public class SleepController {
    @Autowired
    private SleepRepository sleepRepository;

    private ObjectMapper objectMapper = new ObjectMapper();
    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");

    @PostMapping(path = "/add")
    public ResponseEntity addSleep(@RequestBody SleepRequestBinder sleepRequestBinder) {
        ZonedDateTime start = null;
        ZonedDateTime end = null;
        SleepModel.Feel feel = null;

        log.info("Request is: ", sleepRequestBinder);

        try {
            start = ZonedDateTime.parse(sleepRequestBinder.getStart(), dateTimeFormatter);
            end = ZonedDateTime.parse(sleepRequestBinder.getEnd(), dateTimeFormatter);
            feel = SleepModel.Feel.valueOf(sleepRequestBinder.getFeel());
        }
        catch (IllegalArgumentException ie) {
            log.error("Incorrect request format.", ie);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        catch (NullPointerException ne) {
            log.error("Required sleep data not found.", ne);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        catch (DateTimeParseException pe) {
            log.error("Could not parse time.", pe);
        }
        catch (Exception e) {
            log.error("Unexpected exception.", e);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        SleepModel sleep = new SleepModel();
        sleep.setStart(start);
        sleep.setEnd(end);
        sleep.setFeel(feel);
        sleepRepository.save(sleep);

        return new ResponseEntity(HttpStatus.OK);
    }

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
