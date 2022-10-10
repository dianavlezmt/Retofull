package co.usa.ciclo32022.Reto3.Repository;

import co.usa.ciclo32022.Reto3.Repository.crudrepository.DoctorCrudRepository;
import co.usa.ciclo32022.Reto3.modelo.DoctorModel;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Repository
public class DoctorRepository {

    @Autowired
    private DoctorCrudRepository doctorCrudRepository;

    public List<DoctorModel> getAllDoctor(){
        return (List<DoctorModel>) doctorCrudRepository.findAll();
    }

    public Optional<DoctorModel> getDoctor(int id){
        return doctorCrudRepository.findById(id);
    }

    public DoctorModel save(DoctorModel doctorModel){
        return doctorCrudRepository.save(doctorModel);
    }
    public void delete(DoctorModel doctorModel){
       doctorCrudRepository.delete(doctorModel);
    }

}


