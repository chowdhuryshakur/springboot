package com.managemeeting.managemeetin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@EnableMongoRepositories(basePackageClasses = MemberRepository.class)
public  class memberServiceImpl {

    @Autowired
    private MemberRepository memberRepository;


    public Member save(Member member){
        return memberRepository.save(member);
    }


    public Member update(Member member) {
        return memberRepository.save(member);
    }


    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    public void deleteMember() {
        memberRepository.deleteAll();
    }

    public Member getMember(String memberId) {
        return null;
    }



}
