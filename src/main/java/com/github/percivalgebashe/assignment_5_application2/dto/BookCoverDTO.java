package com.github.percivalgebashe.assignment_5_application2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookCoverDTO {
    private String bookId; // Uses Book ID directly
    private String imagePath;
}
