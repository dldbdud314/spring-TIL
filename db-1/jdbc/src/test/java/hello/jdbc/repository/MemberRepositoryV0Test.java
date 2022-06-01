package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 repository = new MemberRepositoryV0();

    @Test
    void crud() throws SQLException {
        //save
        Member memberV0 = new Member("memberV5", 10000);
        repository.save(memberV0);

        //findById
        Member findMember = repository.findById(memberV0.getMemberId());
        log.info("findMember = {}", findMember);
        assertThat(findMember).isEqualTo(memberV0);

        //update: money 10000 -> 20000
        repository.update(memberV0.getMemberId(), 20000);
        Member updatedMember = repository.findById(memberV0.getMemberId());
        assertThat(updatedMember.getMoney()).isEqualTo(20000);

        //delete
        repository.delete(memberV0.getMemberId());
        assertThatThrownBy(()-> repository.findById(memberV0.getMemberId()))
                .isInstanceOf(NoSuchElementException.class); //예외가 터져야 delete test 성공
    }
}