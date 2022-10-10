package co.usa.ciclo32022.Reto3.Repository.crudrepository;

import co.usa.ciclo32022.Reto3.modelo.ClientModel;
import co.usa.ciclo32022.Reto3.modelo.DoctorModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DoctorCrudRepository extends CrudRepository <DoctorModel, Integer > {

}

