package org.yearup.shopping;

import java.util.Scanner;

public class ShoppingListWithLoopsMain {
    public static void main(String[] args) {


        // Show the user a list of items for sale
        // Only show the product names and IDs, not the prices


        Item[] itemsForSale = ItemsForSale.itemsForSale;
        for (Item i : itemsForSale){
            if (! i.isInStock()) continue;;
            System.out.println(i.getProductID() + " " + i.getDescription());


        }

        // Invite the user to buy something

        System.out.println("Enter the product ID of the item you want to buy:");

        // Read in the user's response

        Scanner scanner = new Scanner(System.in);
        String selectedProductId = scanner.nextLine();



        // Parse their choice and get that item from the list


        Item selectedItem = null;

        for (Item currentItemInTheLoop : itemsForSale){
            if (selectedProductId.equals(currentItemInTheLoop.getProductID())){
                selectedItem = currentItemInTheLoop;
                break;

            }
        }
        if (selectedItem == null){
            System.out.println("Invalid product ID, please try again.");
            main(args);
            return;
        }
        // Tell the user they can have it for a price!

        System.out.println("The price of " + selectedItem.getDescription() + "is $" + selectedItem.getPrice());
        System.out.println("Do you want to buy it? Enter Y for yes or N for no: ");
        // show them the price and ask them to accept it
        String response = scanner.nextLine().toUpperCase();
        if (response.equals("Y")){
            System.out.println("You get it " + selectedItem.getDescription() + " is yours!");
        }else {
            main(args);
        }



    }
}