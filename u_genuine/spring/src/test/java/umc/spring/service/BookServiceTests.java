package umc.spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import umc.study.domain.Book.dto.BookDTO;
import umc.study.domain.Book.service.BookService;

public class BookServiceTests {

    private BookService bookService;

    @BeforeEach
    public void ready(){
        bookService = BookService.INSTANCE;
    }

    @Test
    public void testRegister() throws Exception{

        BookDTO bookDTO = BookDTO.builder()
                .title("test title")
                .author("test author")
                .description("test description")
                .stock(0)
                .build();

        bookService.register(bookDTO);
    }
}
