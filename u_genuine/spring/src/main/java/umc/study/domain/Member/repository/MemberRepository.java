package umc.study.domain.Member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Member.entity.Member;

//@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
