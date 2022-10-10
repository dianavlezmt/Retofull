package co.usa.ciclo32022.Reto3.Service;

import co.usa.ciclo32022.Reto3.Repository.ReservationRepository;
import co.usa.ciclo32022.Reto3.Repository.CountClient;
import co.usa.ciclo32022.Reto3.modelo.ReservationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<ReservationModel> getAllReservation(){
        return reservationRepository.getAll();
    }

    public Optional<ReservationModel> getReservation(int reservationId) {
        return reservationRepository.getReservation(reservationId);
    }

    public ReservationModel save(ReservationModel reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }else{
            Optional<ReservationModel> e= reservationRepository.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public ReservationModel update(ReservationModel reservationModel){
        if(reservationModel.getIdReservation()!=null){
            Optional<ReservationModel> e= reservationRepository.getReservation(reservationModel.getIdReservation());
            if(!e.isEmpty()){

                if(reservationModel.getStartDate()!=null){
                    e.get().setStartDate(reservationModel.getStartDate());
                }
                if(reservationModel.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservationModel.getDevolutionDate());
                }
                if(reservationModel.getStatus()!=null){
                    e.get().setStatus(reservationModel.getStatus());
                }
                reservationRepository.save(e.get());
                return e.get();
            }else{
                return reservationModel;
            }
        }else{
            return reservationModel;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }


    public List<CountClient> getTopClients(){
        return reservationRepository.getTopClients();
    }

    public List<ReservationModel> getReservationsPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date a= new Date();
        Date b=new Date();
        try {
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(a.before(b)){
            return reservationRepository.getReservationPeriod(a,b);
        }else{
            return new ArrayList<>();
        }

    }
    public StatusAmount getReservationsStatusReport(){
        List<ReservationModel>completed=reservationRepository.getReservationsByStatus("completed");
        List<ReservationModel>cancelled=reservationRepository.getReservationsByStatus("cancelled");
        return new StatusAmount(completed.size(),cancelled.size());

    }
}
