import java.util.ArrayList;
import java.util.Scanner;

public class WendowShapengList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> shoppingList = new ArrayList<>();

        System.out.println("Enter up to 5 items to buy:");

        for (int i = 0; i < 5; i++) {
            System.out.print("> Item " + (i + 1) + ": ");
            String item = scanner.nextLine().trim();
            if (!item.isEmpty()) {
                shoppingList.add(item);
            }
        }

        System.out.println("Your shopping list:");
        System.out.println(String.join(", ", shoppingList));

        System.out.println("You entered " + shoppingList.size() + " item(s).");

        System.out.print("Search for an item: ");
        String searchItem = scanner.nextLine().trim();

        if (shoppingList.contains(searchItem)) {
            System.out.println("meron" + searchItem + " is in your shopping list!");
        } else {
            System.out.println("wala ayus kalang ba?" + searchItem + " is NOT in your shopping list.");
        }

        scanner.close();
    }
}
