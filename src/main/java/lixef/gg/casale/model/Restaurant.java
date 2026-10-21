package lixef.gg.casale.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Restaurant {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String email;
    private String description;


    private int maxSeats;

    private LocalTime openTime;
    private LocalTime closeTime;

    @OneToMany(mappedBy = "restaurant")
    private List<Reservation> reservations = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;


    public Restaurant(int seats, Admin admin){
        this.maxSeats=seats;
        this.admin=admin;
    }

//    public boolean areSeatsAvailable(){
//        return true;
//    }


}
