package co.usa.ciclo32022.Reto3.Repository.crudrepository;

import co.usa.ciclo32022.Reto3.modelo.ReservationModel;
import org.springframework.data.repository.CrudRepository;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface ReservationCrudRepository extends CrudRepository<ReservationModel, Integer> {


    //select clientId, count(*) as "total" from reservation group by clientId order by total desc;
    @Query("SELECT c.client, COUNT(c.client) from ReservationModel AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationsByClient();

    public List<ReservationModel> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo );

    public List<ReservationModel>findAllByStatus(String status);
}
