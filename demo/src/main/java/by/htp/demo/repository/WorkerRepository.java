package by.htp.demo.repository;

import by.htp.demo.persist.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {

    @Query("SELECT w FROM Worker w WHERE CONCAT(w.id, ' ',w.surname, ' ', w.name, ' ', w.lastname,'  " +
            "', w.address,'',w.payment,'',w.paymentdata,' ',w.price,' ',w.quantity,' ', w.sum) LIKE %?1%")
    public List<Worker> search(String keyword);

}
