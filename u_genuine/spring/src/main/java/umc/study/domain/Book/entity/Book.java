package umc.study.domain.Book.entity;

import lombok.*;

import javax.persistence.*;


import lombok.Getter;
import umc.study.domain.Category;
import umc.study.domain.common.BaseEntity;

import javax.persistence.Entity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String title;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String author;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, columnDefinition = "DEFAULT 0")
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;



    public Book updateBook(BookUpdateRequest bookUpdateRequest){
        this.title = bookUpdateRequest.getTitle();
        this.description = bookUpdateRequest.getBookDescription;
        return this;
    }

    public int updateStock(int stock){
        this.stock = stock;
        return this.stock;
    }

    public void checkStock(){
        if(this.stock < 1){
            throw new NotExistBookStockException(this.id, this.stock);
        }
    }


//    @OneToMany(mappedBy = "book_id", cascade = CascadeType.ALL)
//    private List<Rent> rentList = new ArrayList<>();

//    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
//    private List<ReturnBook> returnBookList = new ArrayList<>();

//    @OneToMany(mappedBy = "book_id", cascade = CascadeType.ALL)
//    private List<BookHashTag> bookHashTagList  = new ArrayList<>();

//    @OneToMany(mappedBy = "book_id", cascade = CascadeType.ALL)
//    private List<Like> likeList = new ArrayList<>();

}
