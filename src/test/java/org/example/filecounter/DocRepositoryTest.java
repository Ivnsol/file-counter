package org.example.filecounter;

import org.example.filecounter.model.Amount;
import org.example.filecounter.repository.DocRepository;
import org.example.filecounter.repository.DocRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DocRepositoryTest {

    private DocRepository docRepository;

    @BeforeEach
    void setUp() {
        docRepository = new DocRepositoryImpl();
    }

    @Test
    void countDocumentsReturnsCorrectAmount() {
        Path validDirectory = Paths.get("C:\\Users\\Иван Александрович\\Downloads\\111");
        Amount result = docRepository.countDocuments(validDirectory);
        assertNotNull(result);
        Assertions.assertEquals(5, result.getDocuments());
        Assertions.assertEquals(7, result.getPages());
    }

    @Test
    void countDocumentsReturnsWrongAmount() {
        Path validDirectory = Paths.get("C:\\Users\\Иван Александрович\\Downloads\\111");
        Amount result = docRepository.countDocuments(validDirectory);
        assertNotNull(result);
        Assertions.assertNotEquals(8, result.getDocuments());
        Assertions.assertNotEquals(2, result.getPages());
    }

    @Test
    public void testCountDocumentsWithEmptyDirectory() {
        Path validDirectory = Paths.get("C:\\Users\\Иван Александрович\\Downloads\\111\\папка2\\Новая папка");
        Amount result = docRepository.countDocuments(validDirectory);
        assertNotNull(result);
        Assertions.assertEquals(0, result.getDocuments());
        Assertions.assertEquals(0, result.getPages());
    }

    @Test
    void countDocumentsThrowsIllegalArgumentException() {
        Path nonexistentDirectory = Paths.get("nonexistent_directory");
        assertThrows(IllegalArgumentException.class, () -> docRepository.countDocuments(nonexistentDirectory));
    }
}