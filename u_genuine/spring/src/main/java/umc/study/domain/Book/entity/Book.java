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
@ToString
//@AllArgsConstructor
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

    @Column(nullable = false)
    @Builder.Default
    private Integer stock = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Builder
    public Book(Long id, String title, String author, String description, Integer stock, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.stock = stock;
        this.category = category;
    }

//    public Book updateBook(BookUpdateRequest bookUpdateRequest){
//        this.title = bookUpdateRequest.getTitle();
//        this.description = bookUpdateRequest.getBookDescription;
//        return this;
//    }

//    public int updateStock(int stock){
//        this.stock = stock;
//        return this.stock;
//    }

//    public void checkStock(){
//        if(this.stock < 1){
//            throw new NotExistBookStockException(this.id, this.stock);
//        }
//    }


}
