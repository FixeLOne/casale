package lixef.gg.casale.services;


import lixef.gg.casale.model.Restaurant;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    public Restaurant createRestaurant(String name){

        Restaurant restaurant= new Restaurant();
        restaurant.setName(name);

        return restaurant;
    }


}
