package umc.study.domain.HashTag.entity;

import lombok.*;
import umc.study.global.common.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor
public class HashTag extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hash_tag_id")
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String name;

    @Builder
    public HashTag(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
