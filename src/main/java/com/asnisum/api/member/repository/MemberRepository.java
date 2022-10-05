package com.asnisum.api.member.repository;

import com.asnisum.api.member.entity.Member;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    @Query("select m from Member m where m.memberId=:memberId")
    Member findByMemberId(@Param("memberId") String memberId);

    boolean existsByMemberId(String memberId);

    boolean existsByEmail(String email);

}
