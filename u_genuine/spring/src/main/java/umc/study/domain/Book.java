package umc.study.domain;

import lombok.*;

import javax.persistence.*;


import lombok.Getter;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.mapping.BookHashTag;
import umc.study.domain.mapping.Like;
import umc.study.domain.mapping.Rent;
import umc.study.domain.mapping.ReturnBook;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

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

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "DEFAULT 0")
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;


//    @OneToMany(mappedBy = "book_id", cascade = CascadeType.ALL)
//    private List<Rent> rentList = new ArrayList<>();

//    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
//    private List<ReturnBook> returnBookList = new ArrayList<>();

//    @OneToMany(mappedBy = "book_id", cascade = CascadeType.ALL)
//    private List<BookHashTag> bookHashTagList  = new ArrayList<>();

//    @OneToMany(mappedBy = "book_id", cascade = CascadeType.ALL)
//    private List<Like> likeList = new ArrayList<>();

}
