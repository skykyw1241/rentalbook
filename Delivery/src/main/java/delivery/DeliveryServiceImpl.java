package delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import delivery.BookDelivery;
import delivery.DeliveryRepository;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository;

    /**
     * 배송 시작
     */
    public void startDelivery(BookDelivery delivery){
        System.out.println("System is down~");
    }

    /**
     * 배송 변경
     */
    public void updateDelivery(Long deliveryId, BookDelivery delivery){
        deliveryRepository.save(delivery);
    }

}
