package delivery;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<BookDelivery, Long> {

    //List<BookDelivery> findByOrderIdOrderByDeliveryIdDesc(Long rentalId);

}
