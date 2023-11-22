package umc.study.domain;

import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.mapping.BookHashTag;
import umc.study.domain.mapping.Like;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class HashTag extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hash_tag_id")
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String name;

//    @OneToMany(mappedBy = "hashTag_id", cascade = CascadeType.ALL)
//    private List<BookHashTag> bookHashTagList = new ArrayList<>();


}
