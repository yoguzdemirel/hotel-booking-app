
package app;


import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean[][] rooms = new boolean[7][7];
        initializeRooms(rooms);
        displayRooms(rooms);
        System.out.println("There are " + countAvailableRooms(rooms) + " available rooms in our hotel");
        System.out.println("*************");
        displayMenu();

        while (true) {
            int input = scanner.nextInt();
            if (input == 1) {
                System.out.println("Which floor do you want to select?");
                int floorNumber = scanner.nextInt();
                System.out.println("Which room do you want to select?");
                int roomNumber = scanner.nextInt();
                selectFloorAndRoom(floorNumber, roomNumber, rooms);
            } else if (input == 2) {
                System.out.println("Which floor do you want to remove?");
                int floorNumber = scanner.nextInt();
                System.out.println("Which room do you want to remove?");
                int roomNumber = scanner.nextInt();
                removeFloorAndRoom(floorNumber, roomNumber, rooms);
            } else if (input == 3) {
                System.out.println("Checking if there are 3 rooms...");
                isThereAny3Room(rooms);
            } else if (input == -1) {
                System.out.println("Bye bye");
                break;
            } else {
                System.out.println("Wrong input");
                break;
            }
        }
    }

    public static void displayMenu() {
        System.out.println("For reservation, press 1.");
        System.out.println("To remove room, press 2.");
        System.out.println("To reserve 3 rooms, press 3.");
        System.out.println("Press -1 to exit.");
    }

    public static void initializeRooms(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = false;
            }
        }
    }

    public static void displayRooms(boolean arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            System.out.println((i + 1) + "th floor");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(j + 1 + ". room " + arr[i][j] + "       ");
            }
            System.out.println("");
        }
    }

    public static int countAvailableRooms(boolean[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (!arr[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void selectFloorAndRoom(int floorNumber, int roomNumber, boolean[][] arr) {
        if (!arr[floorNumber - 1][roomNumber - 1]) {
            arr[floorNumber - 1][roomNumber - 1] = true;
            System.out.println("Room selected");
            displayRooms(arr);
            displayMenu();
        } else {
            System.out.println("Room is already reserved");
        }
    }

    public static void removeFloorAndRoom(int floorNumber, int roomNumber, boolean[][] arr) {
        if (arr[floorNumber - 1][roomNumber - 1]) {
            arr[floorNumber - 1][roomNumber - 1] = false;
            System.out.println("Room removed");
            displayRooms(arr);
            displayMenu();
        } else {
            System.out.println("Room is already vacant");
        }
    }

    public static void isThereAny3Room(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length - 2; j++) {
                if (!arr[i][j] && !arr[i][j + 1] && !arr[i][j + 2]) {
                    System.out.println("On the " + (i + 1) + "th floor, there are 3 vacant rooms");
                    System.out.println("Room numbers are: " + (j + 1) + ", " + (j + 2) + ", " + (j + 3));
                    return;
                }
            }
        }
        System.out.println("No sequence of 3 vacant rooms found.");
    }
}
