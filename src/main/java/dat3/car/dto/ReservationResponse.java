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
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate reservationDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate rentalDate;
    private int carId;
    private String carBrand;
    private String carModel;
    private double price;



    public ReservationResponse(Reservation r) {
        this.reservationDate = r.getReservationDate();
        this.rentalDate = r.getRentalDate();
        this.carId = r.getCar().getId();
        this.id = r.getId();
        this.carBrand = r.getCar().getBrand();
        this.carModel = r.getCar().getModel();
        this.price = r.getCar().getPricePrDay();

    }

    public static ReservationResponse fromReservation(Reservation r) {
        return new ReservationResponse(r);
    }
}
