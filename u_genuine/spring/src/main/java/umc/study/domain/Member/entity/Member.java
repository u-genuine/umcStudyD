package umc.study.domain.Member.entity;

import lombok.*;
import umc.study.domain.common.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
//@AllArgsConstructor 대신 생성자에 @Builder 붙이기
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(20)")
    private String name;

    @Column(nullable = false, columnDefinition = "VARCHAR(10)")
    private String nickname;

    @Column(columnDefinition = "VARCHAR(10)")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(columnDefinition = "VARCHAR(20)")
    private String phonenum;

    @Column(nullable = false, columnDefinition = "VARCHAR(20)")
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private MemberStatus status = MemberStatus.ACTIVE;

    @Column(columnDefinition = "DATETIME")
    private LocalDate inactiveDate;

    @Column(nullable = false, columnDefinition = "VARCHAR(20)")
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Level level = Level.USER;

//    public Member update(String nickname, Gender gender, String phonenum, MemberStatus status, LocalDate inactiveDate, Level level) {
//        this.nickname = nickname;
//        this.gender = gender;
//        this.phonenum = phonenum;
//        this.status = status;
//        this.inactiveDate = inactiveDate;
//        this.level = level;
//        return this;
//    }

    @Builder
    public Member(Long id, String name, String nickname, Gender gender, String phonenum, MemberStatus status, LocalDate inactiveDate, Level level) {
        this.name = name;
        this.nickname = nickname;
        this.gender = gender;
        this.phonenum = phonenum;
        this.status = status;
        this.inactiveDate = inactiveDate;
        this.level = level;
    }

}