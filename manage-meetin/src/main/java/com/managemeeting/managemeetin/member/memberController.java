package com.managemeeting.managemeetin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/rest/member")
public class memberController {

    @Autowired(required=true)
    private memberServiceImpl memberServiceImpl;

    @PostMapping("/save")
    public Member save(@RequestBody Member member){
        return memberServiceImpl.save(member);
    }

    @PutMapping("/update")
    public Member update(@RequestBody Member member){
        return memberServiceImpl.update(member);
    }

    @GetMapping("/all")
    public List<Member> getAll(){
        return  memberServiceImpl.getAllMember();
    }

    @GetMapping("/by/{memberId}")
    public Member getMember(@PathVariable(name="memberId") String memberId){
        return memberServiceImpl.getMember(memberId);
    }
   @DeleteMapping("/delete")
        public void deleteAllMember(){    //(@PathVariable(name = "mId")Integer mId){
       memberServiceImpl.deleteAllMember();
    }



    @DeleteMapping("/delete/{memberId}")
    public void deleteMeeting(@PathVariable(name = "memberId") String memberId){
        memberServiceImpl.deleteMember(memberId); }

}
