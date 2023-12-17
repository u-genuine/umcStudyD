package umc.study.domain.Rent.entity;


import lombok.*;
import umc.study.domain.Book.entity.Book;
import umc.study.domain.Member.entity.Member;
import umc.study.domain.common.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor
public class Rent extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private RentStatus rentStatus = RentStatus.ON_RENT;

    @Column(nullable = false, columnDefinition = "DATE")
    @Builder.Default
    private LocalDate rentDate = LocalDate.now();

    @Column(nullable = false, columnDefinition = "DATE")
    @Builder.Default
    private LocalDate expirationDate = LocalDate.now().plusDays(10);

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @Builder
    public Rent(Long id, RentStatus rentStatus, LocalDate rentDate, LocalDate expirationDate, Member member, Book book) {
        this.id = id;
        this.rentStatus = rentStatus;
        this.rentDate = rentDate;
        this.expirationDate = expirationDate;
        this.member = member;
        this.book = book;
    }
    //    public Rent(RentStatus rentStatus, LocalDate rentDate, LocalDate expirationDate){
//        this.rentStatus = RentStatus.ON_RENT;
//        this.expirationDate = LocalDate.now().plusWeeks(1);
//        this.rentDate = LocalDate.now();
//    }

}
