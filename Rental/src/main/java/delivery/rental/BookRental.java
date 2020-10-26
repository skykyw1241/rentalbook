package delivery.rental;

import javax.persistence.*;

import delivery.delivery.BookDelivery;
import delivery.delivery.DeliveryService;
import delivery.RentalApplication;

@Entity
@Table(name="BookRental_table")
public class BookRental {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long bookId;
    private Long deliveryId;
    private Long qty;
    private Long customerId;
    private String status;

    @PrePersist
    public void onPrePersist(){

        BookRentSaved bookRentSaved = new BookRentSaved();
        bookRentSaved.setId(this.id);
        bookRentSaved.setBookId(this.bookId);
        bookRentSaved.setQty(this.qty);
        bookRentSaved.setCustomerId(this.customerId);
        this.status = "등록";
        try{
            bookRentSaved.publish();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("*********************** sending Order Created ***********************");

    }

    /**
     * 주문이 들어옴
     */
    @PostPersist
    private void onPostPersist(){

        BookRentSaved bookRentSaved = new BookRentSaved();
        bookRentSaved.setId(this.id);
        bookRentSaved.setBookId(this.bookId);
        bookRentSaved.setQty(this.qty);
        bookRentSaved.setCustomerId(this.customerId);
        this.status = "등록";

        BookDelivery delv = new BookDelivery();
        delv.setRentalId(this.getId());

        // 배송 시작
        DeliveryService deliveryService = RentalApplication.applicationContext.getBean(DeliveryService.class);
        deliveryService.startDelivery(delv);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }
    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {  this.status = status;    }
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
