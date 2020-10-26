package delivery.rental;

import delivery.RentalApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookRentalController {
  @Autowired
  BookRentalService BookRentService;

@GetMapping("/rental/{rentalId}")
BookRental productStockCheck(@PathVariable(value = "rentalId") Long rentalId) {
 return  this.BookRentService.getRentalById(rentalId);
}

@PostMapping("/rental")
BookRental productInsert(@RequestBody String data) {
 System.out.println(data);
 return this.BookRentService.save(data);
}

@Value("${superuser.userId}")
String superUserId;

@Autowired
Environment env;
/**
 * env 혹은 설정 값을 가져오는 테스트 코드
 */
@GetMapping("/env")
String getEnvSample() {

 // 1. applicationContext 에서 가져오기
 Environment envContext = RentalApplication.applicationContext.getEnvironment();
 System.out.println(" applicationContext = " + envContext.getProperty("superuser.userId"));

 // 2. Autowired Environment
 System.out.println(" Autowired Environment = " + env.getProperty("superuser.userId"));

 // 3. @Value
 System.out.println(" @Value = " + superUserId);

 return superUserId;
 }
 }
