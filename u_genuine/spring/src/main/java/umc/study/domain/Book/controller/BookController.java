package umc.study.domain.Book.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.domain.Book.entity.Book;
import umc.study.domain.Book.service.BookService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/books") //api 받을 주소, 버전 관리할거면 v1같은거 넣기
@RestController
@AllArgsConstructor
public class BookController {
    private BookService bookService;

    //도서 전체 조회
    @GetMapping
    public List<Book> getBookList(){
        return bookService.findAll();
    }

    //id로 도서 조회
    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id") Long id){
        return bookService.findOne(id);
    }

    //도서 등록
    @PostMapping
    public Book saveBook(@RequestBody Book book){
        return bookService.save(book);
    }

    //도서 수정
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable(value="id") Long id, @Valid @RequestBody Book book){
        return bookService.update(id, book);
    }

    //도서 삭제
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.delete(id);
    }
}
