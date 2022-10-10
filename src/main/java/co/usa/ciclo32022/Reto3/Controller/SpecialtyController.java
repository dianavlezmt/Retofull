package co.usa.ciclo32022.Reto3.Controller;

import co.usa.ciclo32022.Reto3.Service.SpecialtyService;
import co.usa.ciclo32022.Reto3.modelo.SpecialtyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Specialty")
@CrossOrigin(origins = "*")
public class SpecialtyController {

    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping("/all")
    public List<SpecialtyModel> getAllSpecialties(){
        return specialtyService.getAllSpecialty();
    }
    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<SpecialtyModel> getAllSpecialties2(){
        return specialtyService.getAllSpecialty();
    }

    @GetMapping("/{id}")
    public Optional<SpecialtyModel> getSpecialty(@PathVariable Integer id){
        return specialtyService.getSpecialty(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public SpecialtyModel saveSpecialty(@RequestBody SpecialtyModel specialtyModel){
        return specialtyService.save(specialtyModel);
    }
    @DeleteMapping("/delete/{id}")
    public boolean deleteSpecialty(@PathVariable Integer id){
        return specialtyService.deleteSpecialty(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public SpecialtyModel updateSpecialty(@RequestBody SpecialtyModel specialtyModel){
        return specialtyService.update(specialtyModel);
    }
}
