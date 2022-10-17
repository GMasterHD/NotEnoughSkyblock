package de.dragonsroar.nes.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Drop {
    private final String id;
    private int count;
}
