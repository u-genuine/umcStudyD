package umc.study.domain.Rent.entity;


import lombok.*;
import umc.study.domain.Book.entity.Book;
import umc.study.domain.Member.entity.Member;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.mapping.ReturnBook;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Rent extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private RentStatus rentStatus = RentStatus.ON_RENT;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate rentDate = LocalDate.now();

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate expirationDate = LocalDate.now().plusWeeks(1);

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;


//    @OneToOne
//    @JoinColumn(name = "returnBook_id")
//    private ReturnBook returnBook;

//    @OneToOne(mappedBy = "rent_id", cascade = CascadeType.ALL)
//    private ReturnBook returnBook;




}
