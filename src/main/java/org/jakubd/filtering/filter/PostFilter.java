package org.jakubd.filtering.filter;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PostFilter {
    private String author;
    private String title;
    private LocalDate from;
    private LocalDate to;
    private List<String> tags;
}
