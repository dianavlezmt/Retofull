package co.usa.ciclo32022.Reto3.Repository;

import co.usa.ciclo32022.Reto3.Repository.crudrepository.SpecialtyCrudRepository;
import co.usa.ciclo32022.Reto3.modelo.SpecialtyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SpecialtyRepository {

    @Autowired
    private SpecialtyCrudRepository specialtyCrudRepository;
    public List<SpecialtyModel> getAllSpecialty(){
        return (List<SpecialtyModel>) specialtyCrudRepository.findAll();
    }
    public Optional<SpecialtyModel> getSpecialty(int id){
        return specialtyCrudRepository.findById(id);
    }

    public SpecialtyModel save(SpecialtyModel specialtyModel){
        return specialtyCrudRepository.save(specialtyModel);
    }
    public void delete(SpecialtyModel specialtyModel){
        specialtyCrudRepository.delete(specialtyModel);
    }
}
