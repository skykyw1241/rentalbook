package delivery.rental;

public interface BookRentalService {
    void decreaseStock(Long productId, int quantity);
    void increaseStock(Long productId, int quantity);
    BookRental getRentalById(Long id);
    BookRental save(String data);
}
