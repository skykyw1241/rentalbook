package delivery.rental;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BookRentalServiceImpl implements BookRentalService {

    @Autowired
    BookRentalRepository bookRentalRepository;

    public void decreaseStock(Long productId, int quantity) {

        /**
         * 주문이 발생시, 수량을 줄인다.
         */
        Optional<BookRental> productOptional = bookRentalRepository.findById(productId);
        BookRental Book = productOptional.get();
        //product.setStock(product.getStock() - quantity);

        //bookRentalRepository.save(product);

    }

    public void increaseStock(Long productId, int quantity) {
        /**
         * 주문 취소시, 수량을 늘인다
         */
        Optional<BookRental> productOptional = bookRentalRepository.findById(productId);
        BookRental rental = productOptional.get();
        //product.setStock(product.getStock() + quantity);

        //bookRentalRepository.save(product);
    }

    /**
     * 상품 조회
     */
    public BookRental getRentalById(Long id){
        System.out.println("id="+id);
        Optional<BookRental> productOptional = bookRentalRepository.findById(id);
        System.out.println("productOptional="+productOptional);
        BookRental product = productOptional.get();
        System.out.println("product="+product);
        return product;
    }

    public BookRental save(String data){
        ObjectMapper mapper = new ObjectMapper();
        BookRental product = null;
        try {
            product = mapper.readValue(data, BookRental.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bookRentalRepository.save(product);
    }
}
