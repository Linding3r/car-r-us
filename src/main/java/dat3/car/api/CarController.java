package dat3.car.api;

import dat3.car.dto.CarRequest;
import dat3.car.dto.CarResponse;
import dat3.car.service.CarService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("api/cars")
class CarController {

    CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    //MEMBER
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping
    List<CarResponse> getCars(){
        return carService.getCars(false);
    }

    //MEMBER
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping(path = "/{carId}")
    CarResponse getCarById(@PathVariable int carId)  {
        return carService.getCarById(carId);
    }

    //Admin
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CarResponse addCar(@RequestBody CarRequest body){
        return carService.addCar(body);
    }

    //ADMIN
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{carId}")
    ResponseEntity<Boolean> editCar(@RequestBody CarRequest body, @PathVariable int carId){
        return carService.editCar(body, carId);
    }

    //ADMIN
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{carId}")
    void deleteCarById(@PathVariable int carId){
        carService.deleteCarById(carId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{carBrand}/{carModel}")
    List<CarResponse> getCarsByBrandAndModel(@PathVariable String carBrand, @PathVariable String carModel){
        return carService.getCarByBrandAndModel(carBrand, carModel);
    }

    @GetMapping("/average-price")
    Double getAveragePrice(){
        return carService.getAveragePrice();
    }

    @GetMapping("/available")
    List<CarResponse> getAvailableCars(){
        return carService.getAvailableCars();
    }
}
