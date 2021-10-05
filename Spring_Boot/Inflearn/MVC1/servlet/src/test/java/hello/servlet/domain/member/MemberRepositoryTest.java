package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given ~일때
        Member member = new Member("yang", 12);

        //when ~하면
        Member saveMember = memberRepository.save(member);

        //then ~해야 한다.
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember); //assirtj 의 Assertions사용하기!
    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("member1", 12);
        Member member2 = new Member("member2", 13);
        memberRepository.save(member1); memberRepository.save(member2);

        //when
        List<Member> list = memberRepository.findAll();

        //then
        assertThat(list.size()).isEqualTo(2);
        assertThat(list).contains(member1, member2);
    }
}