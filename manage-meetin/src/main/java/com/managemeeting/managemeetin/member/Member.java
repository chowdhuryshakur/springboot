package com.managemeeting.managemeetin.member;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;

@Entity
@Document (collection = "member")
public class Member {
    @Id
    private String memberId;

    @Field(value = "membername")
    private String memberName;

    @Field(value = "designation")
    private String designation;

    @Field(value = "department")
    private String department;

    public Member() {
    }

    public Member(String memberId, String memberName, String designation, String department) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.designation = designation;
        this.department = department;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", designation='" + designation + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
