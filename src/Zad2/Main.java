package Zad2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String path = "cars.txt";
        try {
            Queue<Vehicle> vehicles = getVehicles(path);
            int chose = 1;
            do {
                chose = showMenu();
                switch (chose) {
                    case 0:
                        saveQueue(vehicles, path);
                        System.out.println("Zamykam program");
                        break;
                    case 1:
                        System.out.println("Wczytywanie pojazdu");
                        vehicles.add(addNewCar());
                        break;
                    case 2:
                        showNextVehicle(vehicles);
                        break;
                    default:
                        System.out.println("Nie poprawna opcja programu");
                }
            }while (chose != 0) ;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
            System.out.println("Niepoprawne dane");
        }
        scanner.close();
    }

    private static void showNextVehicle(Queue<Vehicle> vehicles) {
        Vehicle vehicle = vehicles.poll();
        if (vehicle != null)
        System.out.println("Przyjecie pojazdu\n" + vehicle.toString() + "\n");
        else
            System.out.println("Nie ma wiecej pojazdow");
    }

    private static Vehicle addNewCar () throws NumberFormatException{
        Vehicle vehicle = new Vehicle();
        System.out.print("Podaj typ pojazdu ");
        vehicle.setTyp(scanner.nextLine());
        System.out.print("Podaj marke pojazdu ");
        vehicle.setBrand(scanner.nextLine());
        System.out.print("Podaj model pojazdu ");
        vehicle.setModel(scanner.nextLine());
        System.out.print("Podaj rok pojazdu ");
        vehicle.setYear(Integer.valueOf(scanner.nextLine()));
        System.out.print("Podaj przebieg pojazdu ");
        vehicle.setMileage(Integer.valueOf(scanner.nextLine()));
        System.out.print("Podaj VIN ");
        vehicle.setVin(scanner.nextLine());
        return vehicle;
    }
    private static int showMenu(){
        System.out.println("Co chcesz zrobic?" +
                "\n0 - zakoncz program" +
                "\n1 - wczytaj dane nowego pojazdu" +
                "\n2 - wybierz kolejny pojazd do przegladu");
        return Integer.valueOf(scanner.nextLine());
    }

    private static void saveQueue (Queue<Vehicle> vehicles, String path) throws IOException {
        FileWriter fw = new FileWriter(new File(path));
        BufferedWriter bw = new BufferedWriter(fw);
        for (Vehicle vehicle : vehicles){
            bw.write(vehicle.csvFormat());
        }
        bw.close();
    }

    private static Queue<Vehicle> getVehicles (String path) throws IOException {
        Queue<Vehicle> vehicles = new LinkedList<>();
        File file = new File(path);
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()){
            String[] split = fileScanner.nextLine().split(";");
            Vehicle vehicle = new Vehicle(split[0], split[1], split[2], Integer.valueOf(split[3]), Integer.valueOf(split[4]), split[5]);
            vehicles.offer(vehicle);
        }
        fileScanner.close();
        return vehicles;
    }
}
