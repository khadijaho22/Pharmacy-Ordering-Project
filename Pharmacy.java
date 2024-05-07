package com.example.demo6;

import java.util.ArrayList;
import java.util.Scanner;
public class Pharmacy {
    private int capacity;
    double totalsale = 0;
    private ArrayList<Drug> drugs;

    public Pharmacy(int capacity) {
        this.capacity = capacity;
        this.drugs = new ArrayList<Drug>();
    }
    public Pharmacy(){
        this.capacity = 0;
        this.drugs = new ArrayList<Drug>();
    }
    void setCapacity(int capacity){
        this.capacity = capacity;
    }
    int getCapacity(){
        return capacity;
    }

    public boolean addDrug(String name, int id, double price, String category, int quantity) {
        // Scanner scanner = new Scanner(System.in);

        if (drugs.size() >= capacity) {
            System.out.println("Pharmacy is full, cannot add new drugs.");
            return false;
        }

        /*String name = "";
        int id = 0;
        double price = 0.0;
        int category = 0;
        int quantity = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter Drug name: ");
            if (scanner.hasNextLine()) {
                name = scanner.nextLine();
            } else {
                System.out.println("Invalid input. Name must be a string.");
                scanner.nextLine();
                continue;
            }

            System.out.print("Enter Drug ID: ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                scanner.nextLine();
            }

            else {
                System.out.println("Invalid input. ID must be an integer.");
                scanner.nextLine();
                continue;
            }

            System.out.print("Enter Drug Price: ");
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                scanner.nextLine();
            }

            else {
                System.out.println("Invalid input. Price must be a number.");
                scanner.nextLine();
                continue;
            }

            System.out.print("Enter drug category (1 for cosmetics, 2 for prescription drugs, 3 for other): ");
            if (scanner.hasNextInt()) {
                category = scanner.nextInt();
                scanner.nextLine();
            }
            else {
                System.out.println("Invalid input. Category must be from 1-3.");
                scanner.nextLine();
                continue;
            }

            System.out.print("Enter available quantity: ");
            if (scanner.hasNextInt()) {
                quantity = scanner.nextInt();
                scanner.nextLine();
                validInput = true;
            }
            else {
                System.out.println("Invalid input. Quantity must be an integer.");
                scanner.nextLine();
                continue;
            }
        }
         */

        drugs.add(new Drug(name, id,  price,  category,  quantity));
        System.out.println("Drug added successfully!(:");
        return true;
    }

    public Boolean removeDrug(int id) {
        //Scanner scanner = new Scanner(System.in);

        //System.out.print("Enter ID of drug to remove: ");
        //int id = scanner.nextInt();
        //scanner.nextLine();

        for (Drug drug : drugs)
            if (drug.getId() == id) {
                drugs.remove(drug);
                System.out.println("Drug removed successfully.");
                return true;
            }
        System.out.println("Drug not found.");
        return false;
    }
    public boolean isDrugFound(int id){
        for (Drug drug : drugs)
            if (drug.getId() == id) {
                return true;
            }
        return  false;
    }
    public double placeAnorder(int id) {
        for (Drug drug : drugs) {
            if (drug.getId() == id) {
                if (drug.getQuantity() >=1) {
                    drug.setQuantity(drug.getQuantity()-1);
                    if (drug.getCategory() == "cosmetics") {
                        setTotalsale((drug.getPrice() * 1.2 ));
                        System.out.println(drug.getPrice());
                        return drug.getPrice() * 1.2;
                    } else {
                        setTotalsale(drug.getPrice() );
                        System.out.println(drug.getPrice());
                        return drug.getPrice();
                    }
                }
            }
        }
        //fe al main hdrbo fe al quantity 34an 27sb l total sale


        return 0;

    }
    public void setTotalsale(double price){
        totalsale += price;
        System.out.println(totalsale);
    }
    public double getTotalSale(){
        return totalsale;
    }

}