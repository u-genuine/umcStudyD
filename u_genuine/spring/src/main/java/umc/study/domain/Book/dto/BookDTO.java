package umc.study.domain.Book.dto;

import lombok.Getter;
import lombok.Setter;

//DTO 공부 더 해야함..
@Getter
@Setter
public class BookDTO {

    public class BookCreateDTO{
        private String title;
        private String author;
        private String description;
        private Integer stock;
    }

}
