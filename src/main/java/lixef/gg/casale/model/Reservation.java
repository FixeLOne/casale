package lixef.gg.casale.model;

import jakarta.persistence.*;
import lixef.gg.casale.enums.ReservationStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;
    private int people;
    private Instant log;
    private String name;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    public Reservation(Restaurant restaurant, int people, Client client, LocalDateTime date){
        this.people=people;
        this.client=client;
        this.name= client.getName();
        this.date=date;
        this.log= Instant.now();
        this.restaurant=restaurant;
        setStatus(ReservationStatus.PENDING);
    }

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
