package umc.study.domain.mapping;

import lombok.*;
import umc.study.domain.Book.entity.Book;
import umc.study.domain.HashTag.entity.HashTag;
import umc.study.global.common.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor
@ToString
public class BookHashTag extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hash_tag_id")
    private HashTag hashTag;

    @Builder

    public BookHashTag(Long id, Book book, HashTag hashTag) {
        this.id = id;
        this.book = book;
        this.hashTag = hashTag;
    }
}
