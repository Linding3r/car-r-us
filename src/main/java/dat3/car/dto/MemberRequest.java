package dat3.car.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import dat3.car.entity.Member;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberRequest {
    String username;
    String email;
    String password;
    String firstName;
    String lastName;
    String street;
    String city;
    String zip;

    public static Member getMemberEntity(MemberRequest m){
        return new Member(m.getUsername(),m.getPassword(),m.getEmail(), m.getFirstName(), m.getLastName(),m.getStreet(),
                m.getCity(), m.getZip());
    }

    // Member to MemberRequest conversion
    public MemberRequest(Member m){
        this.username = m.getUsername();
        this.password = m.getPassword();
        this.email = m.getEmail();
        this.street = m.getStreet();
        this.city = m.getCity();
        this.zip = m.getZip();
    }
}



