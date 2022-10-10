package co.usa.ciclo32022.Reto3.Service;

import co.usa.ciclo32022.Reto3.Repository.DoctorRepository;
import co.usa.ciclo32022.Reto3.modelo.DoctorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorModel> getAllDoctor(){
        return doctorRepository.getAllDoctor();
    }

    public Optional<DoctorModel> getDoctor(int id) {
        return doctorRepository.getDoctor(id);
    }

    public DoctorModel save(DoctorModel doctorModel){
        if(doctorModel.getId()==null){
            return doctorRepository.save(doctorModel);
        }else{
            Optional<DoctorModel> e= doctorRepository.getDoctor(doctorModel.getId());
            if(e.isEmpty()){
                return doctorRepository.save(doctorModel);
            }else{
                return doctorModel;
            }
        }
    }

    public DoctorModel update(DoctorModel doctorModel){
        if(doctorModel.getId()!=null){
            Optional<DoctorModel> e= doctorRepository.getDoctor(doctorModel.getId());
            if(!e.isEmpty()){
                if(doctorModel.getName()!=null){
                    e.get().setName(doctorModel.getName());
                }
                if(doctorModel.getDepartment()!=null){
                    e.get().setDepartment(doctorModel.getDepartment());
                }
                if(doctorModel.getYear() != null){
                    e.get().setYear(doctorModel.getYear());
                }
                if(doctorModel.getDescription() !=null){
                    e.get().setDescription(doctorModel.getDescription());
                }
                if(doctorModel.getSpecialty() !=null){
                    e.get().setSpecialty(doctorModel.getSpecialty());
                }
                if(doctorModel.getMessages()!=null){
                    e.get().setMessages(doctorModel.getMessages());
                }
                if (doctorModel.getReservations()!=null){
                    e.get().setReservations(doctorModel.getReservations());
                }
                doctorRepository.save(e.get());
                return e.get();
            }else{
                return doctorModel;
            }
        }else{
            return doctorModel;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getDoctor(id).map(costume -> {
            doctorRepository.delete(costume);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}



