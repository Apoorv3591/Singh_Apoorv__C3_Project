import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RestaurantService restaurantService = new RestaurantService();
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        Restaurant restaurant = restaurantService.addRestaurant("Amelie's cafe", "Chennai", openingTime, closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.displayDetails();
        restaurant.addToMenu("Vegetable lasagne", 269);
        restaurant.displayDetails();
        List<String> selectedItems = restaurantService.selectItemsFromMenu(restaurant.getMenu().get(0).getName());
        int totalCost = restaurant.getTotalCostOfItems(selectedItems);
        System.out.printf("Your order will cost: ₹%s",totalCost);
    }
}
