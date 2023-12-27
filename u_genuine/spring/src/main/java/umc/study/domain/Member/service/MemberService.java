//package umc.study.domain.Member.service;
//
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//import umc.study.domain.Book.exception.ResourceNotFoundException;
//import umc.study.domain.Member.entity.Member;
//import umc.study.domain.Member.repository.MemberRepository;
//
//import javax.transaction.Transactional;
//
//@AllArgsConstructor
//@Service
//public class MemberService {
//
//    private MemberRepository memberRepository;
//
//    @Transactional
//    public Member join(Member member){
//        return memberRepository.save(member);
//    }
//
//    @Transactional
//    public Member update(Long id, Member newMember){
//        Member member = memberRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Member", "id", id));
//        member.setNickname(newMember.getNickname());
//        member.setPhonenum(newMember.getPhonenum());
//        member.set
//    }
//}
