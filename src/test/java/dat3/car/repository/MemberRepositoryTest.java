package dat3.car.repository;

import dat3.car.entity.Car;
import dat3.car.entity.Member;

import dat3.car.entity.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    public MemberRepository memberRepository;
    @Autowired
    public ReservationRepository reservationRepository;
    @Autowired
    public CarRepository carRepository;

    @BeforeEach
    void setUp() {
        Member m1 = new Member("m1", "test12", "m1@a.dk", "bb", "Olsen", "xx vej 34", "Lyngby", "2800");
        Member m2 = new Member("m2", "test12", "m2@a.dk", "aa", "hansen", "xx vej 34", "Lyngby", "2800");
        memberRepository.save(m1);
        memberRepository.save(m2);
        Car c1 = new Car("brand1", "model1", 100, 10);
        Car c2 = new Car("brand2", "model2", 200, 20);
        carRepository.save(c1);
        carRepository.save(c2);
    }

    /*@Test
    void findAllMemberWithRestest() {
        Member m1 = memberRepository.findById("m1").get();
        Car c1 = carRepository.findById(1).get();
        reservationRepository.save(new Reservation(c1, m1, LocalDate.now(), LocalDate.now().plusDays(1)));
        assertEquals(1, memberRepository.findAllWithReservations().size());

    }*/




}
