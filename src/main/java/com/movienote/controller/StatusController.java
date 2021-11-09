package com.movienote.controller;

import com.movienote.model.Status;
import com.movienote.service.StatusService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для сущности Status
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */

@RestController
@AllArgsConstructor
@RequestMapping("/status")
public class StatusController {

    private final StatusService statusService;

    @GetMapping()
    public List<Status> getAllStatuses() {

        return statusService.getAll();
    }

}



