package delivery.config.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface KafkaProcessor {
    String bookSaved_INPUT = "bookSaved-in";
    String bookSaved_OUTPUT = "bookSaved-out";

    String customerSaved_INPUT = "customerSaved-in";
    String customerSaved_OUTPUT = "customerSaved-out";

    String rentalSaved_INPUT = "rentalSaved-in";
    String rentalSaved_OUTPUT = "rentalSaved-out";

    String deliverySaved_INPUT = "deliverySaved-in";
    String deliverySaved_OUTPUT = "deliverySaved-out";

    @Input(bookSaved_INPUT)
    SubscribableChannel inboundBookSaved();

    @Output(bookSaved_OUTPUT)
    MessageChannel outboundBookSaved();

    @Input(customerSaved_INPUT)
    SubscribableChannel inboundCustomerSaved();

    @Output(customerSaved_OUTPUT)
    MessageChannel outboundCustomerSaved();

    @Input(rentalSaved_INPUT)
    SubscribableChannel inboundRentalSaved();

    @Output(rentalSaved_OUTPUT)
    MessageChannel outboundRentalSaved();

    @Input(deliverySaved_INPUT)
    SubscribableChannel inboundDeliverySaved();

    @Output(deliverySaved_OUTPUT)
    MessageChannel outboundDeliverySaved();
}
