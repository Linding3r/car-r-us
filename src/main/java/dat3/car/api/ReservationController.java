package dat3.car.api;

import dat3.car.dto.ReservationRequest;
import dat3.car.dto.ReservationResponse;
import dat3.car.entity.Reservation;
import dat3.car.service.ReservationService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservations")
@CrossOrigin
public class ReservationController {

    ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    List<ReservationResponse> getReservations() {
        return reservationService.getReservations();
    }

    @GetMapping(path = "/{reservation_id}")
    ReservationResponse getReservation(@PathVariable int reservation_id) {
        return reservationService.getReservation(reservation_id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ReservationResponse createReservation(@RequestBody ReservationRequest body) {
        return reservationService.makeReservation(body);
    }

    @GetMapping("/member/{username}")
    List<ReservationResponse> getReservationsByUsername(@PathVariable String username){
        return reservationService.getReservationsByUsername(username);
    }
}
