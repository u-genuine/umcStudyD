package umc.study.domain;

import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.UserStatus;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(20)")
    private String name;

    @Column(columnDefinition = "VARCHAR(10)")
    private String nickname;

    @Column(columnDefinition = "VARCHAR(10)")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(columnDefinition = "VARCHAR(20)")
    private String phonenum;

    @Column(nullable = false, columnDefinition = "VARCHAR(20)")
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(columnDefinition = "DATETIME")
    private LocalDate inactiveDate;

//
//    @OneToMany(mappedBy = "member_id", cascade = CascadeType.ALL)
//    private List<Rent> rentList = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member_id", cascade = CascadeType.ALL)
//    private List<ReturnBook> returnBookList = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member_id", cascade = CascadeType.ALL)
//    private List<Like> likeList = new ArrayList<>();


}