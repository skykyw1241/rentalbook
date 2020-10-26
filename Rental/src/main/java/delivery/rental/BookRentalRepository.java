package delivery.rental;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRentalRepository extends PagingAndSortingRepository<BookRental, Long>{

    //List<BookRental> findByName(@Param("name") String bookname);
}