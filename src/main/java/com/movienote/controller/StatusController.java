package com.movienote.controller;

import com.movienote.model.Status;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Контроллер для сущности Status
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */

@RestController
@RequestMapping("/status")
public class StatusController {

    @GetMapping()
    public List<Status> getAllStatuses() {

        List<Status> statuses = new ArrayList<>();

        return statuses;
    }

    @GetMapping("/{name}")
    public Status getStatus(@PathVariable("name") String name) {

        Status status = new Status();

        return status;
    }

    @PostMapping("/{name}")
    public void saveStatus(@PathVariable("name") String name) {

    }

    @PutMapping("/{id}/{name}")
    public Status updateStatus(@PathVariable("id") Long id, @PathVariable("name") String name) {

        Status status = new Status();

        return status;
    }

    @DeleteMapping("/{id}")

    public void deleteStatus(@PathVariable("id") Long id) {

    }

}



