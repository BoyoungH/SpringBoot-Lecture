//package jpabook.jpashop;
//
//import jpabook.jpashop.domain.Member;
////import org.junit.jupiter.api.Test;
//import jpabook.jpashop.repository.MemberRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//@RunWith(SpringRunner.class) // JUnit에게 Spring과 관련된 것을 테스트할 것이라고 알려줌,
//@SpringBootTest
//public class MemberRepositoryTest {
//    @Autowired
//    MemberRepository memberRepository;
//
//    @Test
//    @Transactional
//    @Rollback(false)
//    public void testMember() throws Exception{
//        //given
//        Member member = new Member();
//        member.setName("memberA");
//
//        //when
//        Long savedId = memberRepository.save(member);
//        Member findMember = memberRepository.find(savedId);
//
//        //then
////        assertEquals(findMember.getId(), member.getId());
////        assertEquals(findMember.getUsername(), member.getUsername());
////        assertEquals(findMember, member);
//        assertThat(findMember.getId()).isEqualTo(member.getId());
//        assertThat(findMember.getName()).isEqualTo(member.getName());
//        assertThat(findMember).isEqualTo(member);
//    }
//}