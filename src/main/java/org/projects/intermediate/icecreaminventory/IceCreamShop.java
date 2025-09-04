package org.projects.intermediate.icecreaminventory;
import java.util.Scanner;

class ShopItems {
    int totalCount;

    public class NonVegan {
        public int iceCreamCount;
        public int shakeCount;
        public int totalCount;

        public void increaseCount(int type, int count) {
            if (type == 1) {
                iceCreamCount += count;
            } else if (type == 2) {
                shakeCount += count;
            } else {
                return;
            }

            totalCount = iceCreamCount + shakeCount;
            ShopItems.this.totalCount += count;
        }
    }

    public class Vegan {
        public int smoothieCount;
        public int slushieCount;
        public int totalCount;

        public void increaseCount(int type, int count) {
            if (type == 3) {
                smoothieCount += count;
            } else if (type == 4) {
                slushieCount += count;
            } else {
                return;
            }

            totalCount = smoothieCount + slushieCount;
            ShopItems.this.totalCount += count;
        }
    }
}

public class IceCreamShop {

    public static void main(String[] args) {
        ShopItems shopitem = new ShopItems();
        ShopItems.NonVegan nonVegan = shopitem.new NonVegan();
        ShopItems.Vegan vegan = shopitem.new Vegan();

        int orderType = 0;
        Scanner input = new Scanner(System.in);
        int itemCount = 0;
        String itemName;

        String message = """
                Hello! Welcome to the ice cream shop. We are ready to take your order.
                For ice-cream type 1,
                for shakes type 2,
                for smoothies type 3,
                and for slushies type 4.
                
                If you are done ordering type 0.
                
                """;
        System.out.println(message);
        orderType = input.nextInt();

        while(orderType != 0) {
            System.out.println("How many items of this item would you like to order?");
            itemCount = input.nextInt();

            if (orderType == 1){
                itemName = "ice cream";
                nonVegan.increaseCount(orderType, itemCount);
            } else if (orderType == 2) {
                itemName = "shake";
                nonVegan.increaseCount(orderType, itemCount);
            } else if (orderType == 3) {
                itemName = "smoothie";
                vegan.increaseCount(orderType, itemCount);
            } else if (orderType == 4) {
                itemName = "slushie";
                vegan.increaseCount(orderType, itemCount);
            } else {
                break;
            }

            System.out.println("Adding " + itemCount + " of the item "+ itemName + " to your order!");

            System.out.println("Type a number for the next item in your order:\n1: Ice cream\n2: Shake\n3: Smoothie\n4: Slushie\n");
            orderType = input.nextInt();
        }

        System.out.println("Thank you for your order! Today we have sold \n " + shopitem.totalCount +
                "orders of sweetness!");

        System.out.println(nonVegan.totalCount + " items have been ice cream and shakes.");

        System.out.println(vegan.totalCount + " items have been smoothies and slushies");
    }
}
