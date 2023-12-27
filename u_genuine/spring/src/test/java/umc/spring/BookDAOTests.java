package umc.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import umc.study.domain.Book.BookDAO;
import umc.study.domain.Book.entity.Book;

import java.util.List;

public class BookDAOTests {

    private BookDAO bookDAO;

    @BeforeEach
    public void ready() {
        bookDAO = new BookDAO();
    }

    @Test
    public void testInsert() throws Exception{
        Book book = Book.builder()
                .title("HarryPotter")
                .author("J.K.Rolling")
                .description("...")
                .stock(3)
                .build();

        bookDAO.insert(book);
    }

    @Test
    public void testList() throws Exception{
        List<Book> list = bookDAO.selectAll();

        list.forEach(bookVO -> System.out.println(bookVO));
    }

    @Test
    public void testSelectOne() throws Exception{
        Long tno = 3L; //반드시 존재하는 번호를 이용
        Book book = bookDAO.selectOne(tno);
        System.out.println(book);
    }

    @Test
    public void testUpdateOne() throws Exception{
        Book book = Book.builder()
                .id(2L)
                .title("updatedddd title")
                .author("updatedddd author")
                .description("updatedddd description")
                .stock(50)
                .build();

        bookDAO.updateOne(book);
    }
}
