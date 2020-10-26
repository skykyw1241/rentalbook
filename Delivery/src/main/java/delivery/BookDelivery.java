package delivery;

import javax.persistence.*;

@Entity
@Table(name="BookDelivery_table")
public class BookDelivery {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long rentalId;
    private String costomer;

    public String getCostomer() {
        return costomer;
    }

    public void setCostomer(String costomer) {
        this.costomer = costomer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getRentalId() {
        return rentalId;
    }

    public void setRentalId(Long rentalId) {
        this.rentalId = rentalId;
    }




}
