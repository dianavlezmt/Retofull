package co.usa.ciclo32022.Reto3.Service;

import co.usa.ciclo32022.Reto3.Repository.SpecialtyRepository;
import co.usa.ciclo32022.Reto3.modelo.SpecialtyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    public List<SpecialtyModel> getAllSpecialty() {
        return specialtyRepository.getAllSpecialty();
    }

    public Optional<SpecialtyModel> getSpecialty(int id) {
        return specialtyRepository.getSpecialty(id);
    }

    public SpecialtyModel save(SpecialtyModel specialtyModel) {
        if (specialtyModel.getId() == null) {
            return specialtyRepository.save(specialtyModel);
        } else {
            Optional<SpecialtyModel> specialtyModel1 = specialtyRepository.getSpecialty(specialtyModel.getId());
            if (specialtyModel1.isEmpty()) {
                return specialtyRepository.save(specialtyModel);
            } else {
                return specialtyModel;
            }
        }
    }

    public SpecialtyModel update(SpecialtyModel specialtyModel){
        if(specialtyModel.getId()!=null){
            Optional<SpecialtyModel>g= specialtyRepository.getSpecialty(specialtyModel.getId());
            if(!g.isEmpty()){
                if(specialtyModel.getDescription()!=null){
                    g.get().setDescription(specialtyModel.getDescription());
                }
                if(specialtyModel.getName()!=null){
                    g.get().setName(specialtyModel.getName());
                }
                return specialtyRepository.save(g.get());
            }
        }
        return specialtyModel;
    }
    public boolean deleteSpecialty(int SpecialtyId){
        Boolean d= getSpecialty(SpecialtyId).map(specialty -> {
            specialtyRepository.delete(specialty);
            return true;
        }).orElse(false);
        return d;
    }
}
