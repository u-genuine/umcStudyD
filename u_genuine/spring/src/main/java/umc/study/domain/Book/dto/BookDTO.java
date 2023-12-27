package umc.study.domain.Book.dto;

import lombok.*;

@Builder
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private String description;
    private Integer stock;
}
