package org.example.filecounter.service;

import lombok.RequiredArgsConstructor;
import org.example.filecounter.model.Amount;
import org.example.filecounter.repository.DocRepository;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class DocServiceImpl implements DocService {
    private final DocRepository docRepository;

    public Amount countDocuments(String directoryPath) {
        Path directory = Paths.get(directoryPath);
        return docRepository.countDocuments(directory);
    }
}
