package dat3.car.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.car.entity.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationResponse {

    private int id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate reservationDate;
    private int carId;
    private String username;



    public ReservationResponse(Reservation r) {
        this.reservationDate = r.getReservationDate();
        this.carId = r.getCar().getId();
        this.id = r.getId();
        this.username = r.getMember().getUsername();

    }
}