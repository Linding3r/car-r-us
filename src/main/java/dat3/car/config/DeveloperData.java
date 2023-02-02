package dat3.car.config;

import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.repository.CarRepository;
import dat3.car.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

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

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //System.out.println("Hello world");

        Member member1 = new Member("Lindinger", "123456789", "thomas@gmail.com", "Thomas",
                "Lindinger", "Nørre Farimagsgade 74, 2.th", "København", "1364");
        Member member2 = new Member("Geelan", "987654321", "fie@gmail.com", "Fie",
                "Geelan", "Nørre Farimagsgade 74, 2.th", "København", "1364");

        List<String> colours1 = new ArrayList<>();
        colours1.add("blå");
        colours1.add("rød");
        List<String> colours2 = new ArrayList<>();
        colours2.add("sølv");
        colours2.add("grøn");
        member1.setFavoriteCarColors(colours1);
        member2.setFavoriteCarColors(colours2);

        Map<String, String> phonenumbers = new HashMap<>();
        phonenumbers.put("mobile","12345");
        phonenumbers.put("work", "45678");

        member1.setPhones(phonenumbers);
        member2.setPhones(phonenumbers);


        memberRepository.save(member1);
        memberRepository.save(member2);


        Car car1 = new Car("Volvo", "CX90", 895, 695);
        Car car2 = new Car("BMW", "i330", 795, 645);
        Car car3 = new Car("VW", "ID4", 695, 595);

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);

    }
}
