package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Order order = em.find(Order.class, 1L);
            Long memberId = order.getMemberId();

            Member member = em.find(Member.class, memberId); //객체지향적이지 않다!!
            Member findMember = order.getMember(); //객체지향적인 코드
            /*
            부연: 객체지향세계 -> 참조로 쭉쭉쭉 찾을 수 있어야하는데
            id로 가면 끊겨 들어가 (RDBMS 중심)
            즉, 현재는 객체를 관계형 DB에 맞춘 설계!
            */

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally{
            em.close();
        }

        emf.close();
    }
}
