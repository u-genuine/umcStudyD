package umc.study.domain.Book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Book.entity.Book;


//@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
