package org.example.filecounter.controller;

import lombok.RequiredArgsConstructor;
import org.example.filecounter.model.Amount;
import org.example.filecounter.service.DocService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DocController {
    private final DocService docService;

    @GetMapping("/countDocuments")
    public Amount countDocuments(@RequestParam String directoryPath) {
        return docService.countDocuments(directoryPath);
    }
}
