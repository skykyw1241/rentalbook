package delivery;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Book_table")
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private Long qty;
    private String tag;
    private String 저자;
    private String 출판사;
    private String 상태;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public String get저자() {
        return 저자;
    }

    public void set저자(String 저자) {
        this.저자 = 저자;
    }
    public String get출판사() {
        return 출판사;
    }

    public void set출판사(String 출판사) {
        this.출판사 = 출판사;
    }
    public String get상태() {
        return 상태;
    }

    public void set상태(String 상태) {
        this.상태 = 상태;
    }




}
