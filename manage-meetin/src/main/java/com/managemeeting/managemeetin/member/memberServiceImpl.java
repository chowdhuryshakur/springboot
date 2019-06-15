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
    private Object Null;


    public Member save(Member member){
        return memberRepository.save(member);
    }


    public Member update(Member member) {
        return memberRepository.save(member);
    }


    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    public void deleteAllMember() {
        memberRepository.deleteAll();
    }


    public void deleteMember(String id) {
        memberRepository.deleteById(id);
    }


    public Member getMember(String id) {
        return memberRepository.findById(id).orElse((Member) Null);
    }



}
