package delivery;
import delivery.config.kafka.KafkaProcessor;
import delivery.rental.BookRental;
import delivery.rental.BookRentalRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.cloud.stream.annotation.EnableBinding;


@SpringBootApplication
@EnableBinding(KafkaProcessor.class)
//@EnableFeignClients
public class RentalApplication {
    public static ApplicationContext applicationContext;
    public static void main(String[] args) {
        applicationContext = SpringApplication.run(RentalApplication.class, args);

        BookRentalRepository bookRentalRepository = applicationContext.getBean(BookRentalRepository.class);

        // 초기 상품 셋팅
        String[] products = {"TV", "MASK", "NOTEBOOK", "TABLE", "CLOCK"};
        long i = 1;
        for(String p : products){
            System.out.println(p+" :  input start");
            BookRental book = new BookRental();

            book.setBookId(i);
            book.setDeliveryId(i);
            book.setCustomerId(i);
            book.setQty((long) 10);

            i++;
            BookRentalRepository.save(book);

            System.out.println(p+" :  input end");
        }
    }

    public static KafkaProcessor getBeanForProcessor(){
        return RentalApplication.applicationContext.getBean(KafkaProcessor.class);
    }

}
