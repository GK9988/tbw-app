package org.garvk.recent_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private long id;
    private String title;
    private Integer releaseYear;
    private WatchStatus watchStatus;
    private LocalDateTime createdAt;
}
