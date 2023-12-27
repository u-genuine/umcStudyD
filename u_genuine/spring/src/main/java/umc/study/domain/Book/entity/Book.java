package umc.study.domain.Book.entity;

import lombok.*;
import umc.study.global.common.BaseEntity;

import javax.persistence.*;

@Entity
@Builder
@Getter
@ToString
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

    @Column(nullable = false)
    private Integer stock;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id", nullable = false)
//    private Category category;

//    @Builder
//    public Book(String title, String author, String description, Integer stock){
//        this.title = title;
//        this.author = author;
//        this.description = description;
//        this.stock = stock;
////        this.category = category;
//    }
}
