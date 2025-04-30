package org.garvk.recent_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecentRespDTO {
    List<MovieDto> movies;
    List<ShowDto> shows;
}
