package com.movienote.controller;

import com.movienote.model.Status;
import com.movienote.service.StatusService;
import org.springframework.web.bind.annotation.*;

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

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping()
    public List<Status> getAllStatuses() {

        return statusService.getAll();
    }

}



