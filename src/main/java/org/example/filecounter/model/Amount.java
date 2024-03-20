package org.example.filecounter.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Amount {
    private final int Documents;
    private final int Pages;
}
