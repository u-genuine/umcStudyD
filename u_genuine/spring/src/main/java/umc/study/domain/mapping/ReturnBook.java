package umc.study.domain.mapping;

import lombok.*;
import umc.study.domain.Rent.entity.Rent;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.ReturnStatus;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReturnBook extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "returnBook_id")
    private Long id;

    @Column(nullable = false)
    private LocalDate returnDate;

    @Column(nullable = false, columnDefinition = "DEFAULT 'ON_LOAN'")
    @Enumerated(EnumType.STRING)
    private ReturnStatus returnStatus;

    @OneToOne
    @JoinColumn(name = "rent_id")
    private Rent rent;

//    @OneToOne(mappedBy = "returnBook")
//    private Member member;
//
//    @OneToOne(mappedBy = "returnBook")
//    private Book book;
}
