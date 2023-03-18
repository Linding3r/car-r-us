package dat3.car.config;

import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.entity.Reservation;
import dat3.car.repository.CarRepository;
import dat3.car.repository.MemberRepository;
import dat3.car.repository.ReservationRepository;
import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;
import dat3.security.repository.UserWithRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DeveloperData implements ApplicationRunner {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    CarRepository carRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    UserWithRolesRepository userWithRolesRepository;

    final String passwordUsedByAll = "test12";

    void testdata(){
        Member m1 = new Member("member1", "4321", "memb1@a.dk", "Kurt", "Wonnegut",
                "Lyngbyvej 2", "Lyngby", "2800");
        Member m2 = new Member("member2","4321", "aaa@dd.dk", "Hanne", "Wonnegut",
                "Lyngbyvej 2", "Lyngby", "2800");
        List<String> colours1 = new ArrayList<>();
        colours1.add("blå");
        colours1.add("rød");
        List<String> colours2 = new ArrayList<>();
        colours2.add("sølv");
        colours2.add("grøn");
        m1.setFavoriteCarColors(colours1);
        m2.setFavoriteCarColors(colours2);

        m1.setRoles(List.of(Role.USER));
        m2.setRoles(List.of(Role.ADMIN, Role.USER));

        Map<String, String> phonenumbers = new HashMap<>();
        phonenumbers.put("mobile","12345");
        phonenumbers.put("work", "45678");

        m1.setPhones(phonenumbers);
        m2.setPhones(phonenumbers);


        memberRepository.save(m1);
        memberRepository.save(m2);
          

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Volvo", "CX90", 895, 10));
        cars.add(new Car("BMW", "i330", 795, 6));
        cars.add(new Car("VW", "ID4", 695, 20));
        cars.add(new Car("Toyota", "Camry", 900, 12));
        cars.add(new Car("Tesla", "Model 3", 39000, 5));
        cars.add(new Car("Honda", "Accord", 850, 8));
        cars.add(new Car("Jeep", "Cherokee", 1000, 18));
        cars.add(new Car("Subaru", "Outback", 1100, 14));
        cars.add(new Car("Audi", "A4", 1200, 16));
        cars.add(new Car("Ford", "F150", 1500, 22));
        cars.add(new Car("Kia", "Sorento", 800, 10));
        cars.add(new Car("Hyundai", "Elantra", 700, 12));
        cars.add(new Car("Mazda", "CX5", 950, 14));



        carRepository.saveAll(cars);


        reservationRepository.save(new Reservation(cars.get(0), m1, LocalDate.now(), LocalDate.of(2021,03,05)));
        reservationRepository.save(new Reservation(cars.get(1), m2, LocalDate.now(), LocalDate.of(2021,03,05)));


    }


    /*****************************************************************************************
     NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL
     iT'S ONE OF THE TOP SECURITY FLAWS YOU CAN DO
     *****************************************************************************************/
    private void setupUserWithRoleUsers() {
        System.out.println("******************************************************************************");
        System.out.println("******* NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL ************");
        System.out.println("******* REMOVE THIS BEFORE DEPLOYMENT, AND SETUP DEFAULT USERS DIRECTLY  *****");
        System.out.println("**** ** ON YOUR REMOTE DATABASE                 ******************************");
        System.out.println("******************************************************************************");
        UserWithRoles user1 = new UserWithRoles("user1", passwordUsedByAll, "user1@a.dk");
        UserWithRoles user2 = new UserWithRoles("user2", passwordUsedByAll, "user2@a.dk");
        UserWithRoles user3 = new UserWithRoles("user3", passwordUsedByAll, "user3@a.dk");
        UserWithRoles user4 = new UserWithRoles("user4", passwordUsedByAll, "user4@a.dk");
        user1.addRole(Role.USER);
        user1.addRole(Role.ADMIN);
        user2.addRole(Role.USER);
        user3.addRole(Role.ADMIN);
        //No Role assigned to user4
        userWithRolesRepository.save(user1);
        userWithRolesRepository.save(user2);
        userWithRolesRepository.save(user3);
        userWithRolesRepository.save(user4);
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {

    testdata();
    setupUserWithRoleUsers();
    }



}
