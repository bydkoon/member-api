package com.asnisum.api.member.repository;

import com.asnisum.api.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("select m from Member m where m.idx=:idx")
    Member findByIdx(@Param("idx") Long idx);
    boolean existsByMemberId(String memberId);
    boolean existsByEmail(String email);

}
