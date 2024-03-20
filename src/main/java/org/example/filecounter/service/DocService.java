package org.example.filecounter.service;

import org.example.filecounter.model.Amount;

public interface DocService {
    Amount countDocuments(String directoryPath);
}
