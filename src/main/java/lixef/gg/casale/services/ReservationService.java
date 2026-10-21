package lixef.gg.casale.services;

import lixef.gg.casale.model.Client;
import lixef.gg.casale.model.Reservation;
import lixef.gg.casale.model.Restaurant;
import lixef.gg.casale.repo.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReservationService {

    @Autowired
    ReservationRepo reservationRepo;


    public void createReservation(Restaurant restaurant, int people, Client client, LocalDateTime date){
        Reservation reservation=new Reservation(restaurant, people, client, date);
        reservationRepo.save(reservation);
    }


}
