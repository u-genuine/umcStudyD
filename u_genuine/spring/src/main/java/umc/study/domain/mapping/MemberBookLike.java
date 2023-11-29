package umc.study.domain.mapping;

import lombok.*;
import umc.study.domain.Book.entity.Book;
import umc.study.domain.Member.entity.Member;
import umc.study.domain.common.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor
public class MemberBookLike extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Builder
    public MemberBookLike(Long id, Member member, Book book) {
        this.id = id;
        this.member = member;
        this.book = book;
    }
}
