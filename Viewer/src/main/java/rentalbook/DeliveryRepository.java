package delivery;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeliveryRepository extends CrudRepository<Delivery, Long> {


}