package umc.study.domain.Book.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Book.entity.Book;
import umc.study.domain.Book.exception.ResourceNotFoundException;
import umc.study.domain.Book.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class BookService {

    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findOne(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
    }
    @Transactional
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public Book update(Long id, Book newBook) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
        book.setTitle(newBook.getTitle());
        book.setAuthor(newBook.getAuthor());
        return bookRepository.save(book);
    }

    @Transactional
    public void delete(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
        bookRepository.delete(book);
    }
}

