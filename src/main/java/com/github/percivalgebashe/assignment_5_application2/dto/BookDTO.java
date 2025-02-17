package com.github.percivalgebashe.assignment_5_application2.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Builder
public class BookDTO {
    private String id; // Custom ID based on authors
    private List<AuthorDTO> authors;
    private String title;
    private LocalDate publishedDate;
    private String description;
    private String isbn;
    private String genres; // Comma-separated genres
    private Set<PublisherDTO> publishers;
}