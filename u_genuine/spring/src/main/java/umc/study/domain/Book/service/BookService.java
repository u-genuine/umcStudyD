package umc.study.domain.Book.service;

import org.modelmapper.ModelMapper;
import umc.study.domain.Book.BookDAO;
import umc.study.domain.Book.dto.BookDTO;
import umc.study.domain.Book.entity.Book;
import umc.study.global.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

//@AllArgsConstructor
public enum BookService {
    INSTANCE;

    private BookDAO dao;
    private ModelMapper modelMapper;

    BookService(){
        dao = new BookDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    //BookDTO를 파라미터로 받아서 Book엔티티(VO)로 변환하고 저장
    public void register(BookDTO bookDTO) throws Exception{

        Book book = modelMapper.map(bookDTO, Book.class);

        System.out.println("book: " + book);

        dao.insert(book);
    }

    // BookDAO에서 가져온 Book의 목록을 모두 TodoDTO로 변환해서 반환
    public List<BookDTO> listAll() throws Exception{

        List<Book> bookList = dao.selectAll();

        System.out.println("bookList~~~~~~~~~~~");
        System.out.println(bookList);

        List<BookDTO> dtoList = bookList.stream()
                .map(bookVO-> modelMapper.map(bookVO, BookDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

//
//    public Book findOne(Long id) {
//        return bookRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
//    }
//
//
//    @Transactional
//    public Book update(Long id, Book newBook) {
//        Book book = bookRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
//        book.setTitle(newBook.getTitle());
//        book.setAuthor(newBook.getAuthor());
//        return bookRepository.save(book);
//    }
//
//    @Transactional
//    public void delete(Long id) {
//        Book book = bookRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
//        bookRepository.delete(book);
//    }
}

