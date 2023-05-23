package hello.jdbc.exception.translator;

import static hello.jdbc.connection.ConnectionConst.*;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.ex.MyDBException;
import hello.jdbc.repository.ex.MyDuplicateKeyException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.JdbcUtils;

public class ExTranslatorV1Test {

    Repository repository;
    Service service;

    @BeforeEach
    void init(){
         DataSource datasource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
         repository = new Repository(datasource);
         service = new Service(repository);
    }

    @Test
    void saveDuplicateKey(){
        service.create("myId");
        service.create("myId");
    }

    @Slf4j
    @RequiredArgsConstructor
    static class Service {
         private final Repository repository;

         public void create(String memberId){
             try {
                 repository.save(new Member(memberId, 0));
                 log.info("save={}", memberId);
             }  catch (MyDuplicateKeyException e) {
                 log.info("키 중복, 복구 시도");
                 String retryId = generateNewId(memberId);
                 log.info("retryId={}", retryId);
                 repository.save(new Member(retryId, 0));
             } catch (MyDBException e){
                 log.info("데이터 접근 계층 예외 발생");
                 throw e;
             }
         }

         private String generateNewId(String memberId){
             return memberId + new Random().nextInt(10000);
         }
    }

    @RequiredArgsConstructor
    static class Repository{
        private final DataSource dataSource;

        public void save(Member member){
            String sql = "insert into member(member_id, money) values(?, ?)";
            Connection conn = null;
            PreparedStatement pstmt = null;

            try {
                conn = dataSource.getConnection();
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, member.getMemberId());
                pstmt.setInt(2, member.getMoney());
                pstmt.executeUpdate();
            } catch (SQLException e){
                if (e.getErrorCode() == 23505) throw new MyDuplicateKeyException(e);
            } finally {
                JdbcUtils.closeStatement(pstmt);
                JdbcUtils.closeConnection(conn);
            }
        }



    }
}
