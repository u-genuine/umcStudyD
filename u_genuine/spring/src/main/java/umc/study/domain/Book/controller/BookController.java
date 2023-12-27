package umc.study.domain.Book.controller;

import org.springframework.web.bind.annotation.*;
import umc.study.domain.Book.dto.BookDTO;
import umc.study.domain.Book.service.BookService;

import java.util.List;

@RequestMapping("/books")
@RestController
public class BookController {
    private BookService bookService = BookService.INSTANCE;

    //도서 전체 조회
    @GetMapping("")
    public List<BookDTO> getBookList() throws Exception {
        List<BookDTO> dtoList = bookService.listAll();
        return dtoList;
    }

    //도서 등록
    @PostMapping("")
    public void saveBook(@RequestBody BookDTO bookDTO) throws Exception{
        bookService.register(bookDTO);
    }

//
//    //id로 도서 조회
//    @GetMapping("/{id}")
//    public Book getBook(@PathVariable("id") Long id){
//        return bookService.findOne(id);
//    }
//

//
//    //도서 수정
//    @PutMapping("/{id}")
//    public Book updateBook(@PathVariable(value="id") Long id, @Valid @RequestBody Book book){
//        return bookService.update(id, book);
//    }
//
//    //도서 삭제
//    @DeleteMapping("/{id}")
//    public void deleteBook(@PathVariable Long id){
//        bookService.delete(id);
//    }
}
