package org.example.filecounter.repository;

import org.example.filecounter.repository.formatFabric.DocumentProcessorFabric;
import org.example.filecounter.model.Amount;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

@Component
public class DocRepositoryImpl implements DocRepository {
    public Amount countDocuments(Path directory) {
        if (!Files.exists(directory) || !Files.isDirectory(directory)) {
            throw new IllegalArgumentException("Wrong directory");
        }

        Map<String, Integer> fileCounts = new HashMap<>();
        Map<String, Integer> pageCounts = new HashMap<>();
        DocumentProcessorFabric.PROCESSORS.keySet().forEach(format -> {
            fileCounts.put(format, 0);
            pageCounts.put(format, 0);
        });

        try {
            Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String fileName = file.getFileName().toString().toLowerCase();
                    if (fileName.contains(".") && !Files.isDirectory(file)) {
                        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                        if (fileCounts.containsKey(extension)) {
                            int pageCount = DocumentProcessorFabric.getProcessor(extension).countPages(file.toFile());
                            fileCounts.put(extension, fileCounts.get(extension) + 1);
                            pageCounts.put(extension, pageCounts.get(extension) + pageCount);
                        }
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


        int totalDocuments = fileCounts.values().stream().mapToInt(Integer::intValue).sum();
        int totalPages = pageCounts.values().stream().mapToInt(Integer::intValue).sum();

        return new Amount(totalDocuments, totalPages);
    }

}
