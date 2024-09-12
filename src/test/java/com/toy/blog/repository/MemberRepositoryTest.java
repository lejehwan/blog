package com.toy.blog.repository;

import com.toy.blog.entity.Member;
import com.toy.blog.entity.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    void memberTest() {
        Member member = new Member("userName");
        memberRepository.save(member);

        Member findMember = memberRepository.findById(member.getId()).get();

        assertThat(member).isEqualTo(findMember);
    }
}