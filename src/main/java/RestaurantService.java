import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
        List<Restaurant> restaurantList = getRestaurants();
        Optional<Restaurant> optionalRestaurant =
                restaurantList.stream().filter(res -> res.getName().equals(restaurantName)).findAny();
        if(optionalRestaurant.isPresent()) {
            return optionalRestaurant.get();
        } else {
            throw new restaurantNotFoundException(restaurantName + "not found");
        }
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public List<String> selectItemsFromMenu(String... itemName) {
        return Arrays.asList(itemName);
    }

}
