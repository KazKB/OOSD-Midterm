package com.StockManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Driver {
    static User user;

    public static void main(String[] args) throws IOException {
        Scanner inputScanner = new Scanner(System.in);
        String answer;

        //Asks whether the user wants to login or sign-up
        do {
            System.out.print("Do you want to Login or Sign-Up? Enter L to login and S to Sign-Up: ");
            answer = inputScanner.next();
        } while (!(answer.equalsIgnoreCase("l")) && !(answer.equalsIgnoreCase("s")));

        System.out.println();

        if (answer.equalsIgnoreCase("l")) {
            String inputID, inputPassword;
            String fileInput, fileType = null;
            boolean exist, exist2;

            do {
                Scanner fileScanner = new Scanner(new File("UserDetails.txt"));
                fileScanner.useDelimiter("[,\n]");
                exist = false;
                exist2 = false;

                //Takes login information
                System.out.print("Enter User ID: ");
                inputID = inputScanner.next();
                System.out.print("Enter Password: ");
                inputPassword = inputScanner.next();

                while (fileScanner.hasNext()) {
                    fileInput = fileScanner.next();

                    //Checks for account type
                    if (fileInput.equalsIgnoreCase("admin") || fileInput.equalsIgnoreCase("regular")) {
                        fileType = fileInput;
                        fileInput = fileScanner.next();

                        //Checks for id
                        if (fileInput.equals(inputID)) {
                            exist = true;
                            fileInput = fileScanner.next();

                            //Checks for password
                            if (fileInput.equals(inputPassword)) {
                                exist2 = true;
                                break;
                            }
                        }
                    }
                }

                //If id and password exist, create a user with the account type and id
                //Otherwise print error messages
                if (exist) {
                    if (exist2) {
                        user = new User(fileType, inputID);
                    }
                    else {
                        System.out.println("Password Incorrect!\n");
                    }
                }
                else {
                    System.out.println("ID does not exist!\n");
                }
            } while (!exist || !exist2);
        }

        if (answer.equalsIgnoreCase("s")) {
            String[] input = new String[6];
            String fileInput;
            boolean exist;

            do {
                Scanner scanner = new Scanner(new File("UserDetails.txt"));
                FileWriter writer = new FileWriter("UserDetails.txt", true);
                exist = false;
                scanner.useDelimiter("[,\n]");

                //Takes sign-up information
                System.out.print("Enter First Name: ");
                input[0] = inputScanner.next();
                System.out.print("Enter Last Name: ");
                input[1] = inputScanner.next();
                System.out.print("Enter Email: ");
                input[2] = inputScanner.next();
                System.out.print("Enter Account Type (Admin/Regular): ");
                input[3] = inputScanner.next();
                System.out.print("Enter User ID: ");
                input[4] = inputScanner.next();
                System.out.print("Enter Password: ");
                input[5] = inputScanner.next();

                while (scanner.hasNext()) {
                    fileInput = scanner.next();

                    //Checks if id exists
                    if (fileInput.equals(input[4])) {
                        exist = true;
                        break;
                    }
                }
                scanner.close();

                //Checks If id doesn't exist, account type is admin or regular, and if password is 8 or more characters, then write information to a file
                if (input[3].equalsIgnoreCase("admin") || input[3].equalsIgnoreCase("regular")) {
                    if (!exist) {
                        if (input[5].length() >= 8) {
                            for (int i = 0; i < 5; i++) {
                                writer.append(input[i]).append(",");
                            }
                            writer.append(input[5]).append("\n");
                            writer.close();

                            user = new User(input[0], input[1], input[2], input[3], input[4], input[5]);
                        } else {
                            System.out.println("Password is less than 8 characters!\n");
                        }
                    }
                    else {
                        System.out.println("ID Exists!\n");
                    }
                }
                else {
                    System.out.println("Account type is not admin or regular!\n");
                }
            } while (exist || (!input[3].equalsIgnoreCase("admin") || !input[3].equalsIgnoreCase("regular")) || input[5].length() < 8);
        }


    }
}
