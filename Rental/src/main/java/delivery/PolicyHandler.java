package delivery;

import delivery.config.kafka.KafkaProcessor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import delivery.delivery.BookDelvCanceled;
import delivery.delivery.BookDelvCreated;

@Service
public class PolicyHandler{

    @StreamListener(KafkaProcessor.deliverySaved_INPUT)
    public void onEventByDeliverySaved(@Payload BookDelvCreated bookDelvCreated){
        //  orderPlaced 데이터를 json -> 객체로 파싱
        System.out.println("onEventByProductChanged");
        System.out.println(bookDelvCreated.getEventType());
        //  if문으로 주문생성일때만 작업 진행
        if("BookDelvCreated".equals(bookDelvCreated.getEventType()) ){
            //  상태값 업데이트
        }
    }

    @StreamListener(KafkaProcessor.deliverySaved_INPUT)
    public void onEventByDeliveryCanceled(@Payload BookDelvCanceled bookDelvCanceled){
        //  orderPlaced 데이터를 json -> 객체로 파싱
        System.out.println("onEventByProductChanged");
        System.out.println(bookDelvCanceled.getEventType());
        //  if문으로 주문생성일때만 작업 진행
        if("BookDelvCanceled".equals(bookDelvCanceled.getEventType()) ){
            //  상태값 업데이트
        }
    }
}
