package com.bl.birdsanctuary;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.showUserMenu();

        System.out.println("Good Bye");
    }

    public void showUserMenu() {
        int option = 0;
        Scanner scan = new Scanner(System.in);
        final int EXIT_VALUE = 8;

        while (option != EXIT_VALUE) {
            System.out.println("Enter Your Option");
            System.out.println(
                    "\n1. Add a Bird\n2. Remove Bird\n3. Print Bird List \n4. Print Swimmable \n5. Print Flyable "
                            + "\n6. Print Eatable\n7. Edit Bird\n" + EXIT_VALUE + ". Exit \n");
            option = scan.nextInt();

            ViewLayer viewLayer = new ViewLayer();
            switch (option) {
                case 1:
                    addTemporaryBird();
                    addBird();
                    break;

                case 2:
                    removeBird();
                    break;

                case 3:
                    viewLayer.print();
                    break;

                case 4:
                    viewLayer.printSwimmable();
                    break;

                case 5:
                    viewLayer.printFlyable();
                    break;

                case 6:
                    viewLayer.printEatable();
                    break;

                case 7:
                    editBird();
                    break;
            }
        }
    }

    private void removeBird() {
        Scanner scan = new Scanner(System.in);

        BirdSancturayRepository birdSancturayRepository = BirdSancturayRepository.getInstance();

        System.out.println("Enter the bird name to remove");
        String birdName = scan.next();
        birdSancturayRepository = BirdSancturayRepository.getInstance();
        Bird removeBird = birdSancturayRepository.getBird(birdName);
        birdSancturayRepository.remove(removeBird);
    }

    private void addTemporaryBird(){
        BirdSancturayRepository birdSancturayRepository = BirdSancturayRepository.getInstance();

        Bird duck = new Bird();
        duck.id = "D002";
        duck.name= "Duck";
        duck.color = Bird.Color.WHITE;
        duck.canSwim= true;
        duck.canFly = true;
        birdSancturayRepository.add(duck);

        Bird penguin = new Bird();
        penguin.id ="Pen001";
        penguin.name="Penguin";
        penguin.color= Bird.Color.BLACK_WHITE;
        penguin.canSwim= true;
        penguin.canFly = false;
        birdSancturayRepository.add(penguin);
    }

    private void editBird() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the bird name to edit");
        String birdName = scanner.nextLine();

        Bird editBird = BirdSancturayRepository.getInstance().getBird(birdName);
        int choice = 0;
        while (choice != 4) {
            System.out.println("\n1. Edit bird name\n2. Edit id\n3. Edit color\n4. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the new name");
                    scanner.nextLine();
                    String bName = scanner.nextLine();
                    editBird.name = bName;
                    break;
                case 2:
                    System.out.println("Enter the new id ");
                    scanner.nextLine();

                    String bId = scanner.nextLine();
                    editBird.id = bId;
                    break;
                case 3:
                    System.out.println("Enter the new color");
                    scanner.nextLine();
                    System.out.println("Choose color");

                    int count = 1;
                    for (Bird.Color color : EnumSet.allOf(Bird.Color.class)) {
                        System.out.println("" + count + ", " + color);
                        count++;
                    }

                    int colorChoice = scanner.nextInt();
                    int count1 = 1;
                    for (Bird.Color color : EnumSet.allOf(Bird.Color.class)) {
                        if (colorChoice == count1) {
                            editBird.color = color;
                            break;
                        }
                        count1++;
                    }
                    break;

                case 4:
                    return;

            }
        }
    }
    private void addBird(){
        Scanner scan = new Scanner(System.in);
        Bird bird = new Bird();
        System.out.println("Enter the id");
        String id = scan.nextLine();
        bird.id=id;
        System.out.println("Enter name");
        String name = scan.nextLine();
        bird.name=name;
        System.out.println("Choose the color");
        int count = 1;
        for (Bird.Color color : EnumSet.allOf(Bird.Color.class)) {
            System.out.println("" + count + ", " + color);
            count++;
        }

        int colorChoice = scan.nextInt();
        int count1 = 1;
        for (Bird.Color color : EnumSet.allOf(Bird.Color.class)) {
            if (colorChoice == count1) {
                bird.color = color;
                break;
            }
            count1++;
        }
        System.out.println("Can the bird Fly?? true/flase");
        boolean canFly = scan.nextBoolean();
        bird.canFly = canFly;
        System.out.println("Can the bird Swim?? true/false");
        boolean canSwim = scan.nextBoolean();
        bird.canSwim = canSwim;

        BirdSancturayRepository birdSancturayRepository = BirdSancturayRepository.getInstance();
        birdSancturayRepository.add(bird);
    }
}
