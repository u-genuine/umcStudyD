package umc.study.domain.mapping;


import lombok.*;
import umc.study.domain.Book;
import umc.study.domain.Member;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.ReturnStatus;

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

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate rentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToOne
    @JoinColumn(name = "returnBook_id")
    private ReturnBook returnBook;

//    @OneToOne(mappedBy = "rent_id", cascade = CascadeType.ALL)
//    private ReturnBook returnBook;



}
