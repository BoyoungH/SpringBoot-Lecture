package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepostiory;

    // 회원 등록
    @Transactional // default: readOnly = false, 우선순위를 가짐
    public Long join(Member member){
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepostiory.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // EXCEPTION
        List<Member> findMembers = memberRepostiory.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 전체 조회
    public List<Member> findMembers(){
        return memberRepostiory.findAll();
    }

    // 회원 단건 조회
    public Member findOne(Long memberId){
        return memberRepostiory.findOne(memberId);
    }

    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepostiory.findOne(id);
        member.setName(name);
    }
}
