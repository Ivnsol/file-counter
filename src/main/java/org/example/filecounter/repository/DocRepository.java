package org.example.filecounter.repository;

import org.example.filecounter.model.Amount;

import java.nio.file.Path;

public interface DocRepository {
    Amount countDocuments(Path directory);
}
