package Zad2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String path = "cars.txt";
        //Queue<Vehicle> vehicles = new LinkedList<>();
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
    }

    private static void showNextVehicle(Queue<Vehicle> vehicles) {
        Vehicle vehicle = vehicles.poll();
        if (vehicle !=null)
        System.out.println("Przyjecie pojazdu pojazdu\n" + vehicle.toString() + "\n");
        else
            System.out.println("Nie ma wiecej pojazdow");
    }

    private static Vehicle addNewCar () throws NumberFormatException{
        Scanner scanner = new Scanner(System.in);
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
        //scanner.close();
        return vehicle;
    }
    private static int showMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Co chcesz zrobic?" +
                "\n0 - zakoncz program" +
                "\n1 - wczytaj dane nowego pojazdu" +
                "\n2 - wybierz kolejny pojazd do przegladu");
        int result = scanner.nextInt();
        //scanner.close();
        return result;
    }

    private static void saveQueue (Queue<Vehicle> vehicles, String path) throws IOException {
        FileWriter fw = new FileWriter(new File(path));
        BufferedWriter bw = new BufferedWriter(fw);
        String line = null;
        for (Vehicle vehicle : vehicles){
            line = vehicle.getTyp()+";"+vehicle.getBrand()+";"+vehicle.getModel()+";"+vehicle.getYear()+";"+vehicle.getMileage()+";"+vehicle.getVin()+"\n";
            bw.write(line);
        }
        bw.close();
    }

    private static Queue<Vehicle> getVehicles (String path) throws IOException {
        Queue<Vehicle> vehicles = new LinkedList<>();
        File file = new File(path);
        if (!file.exists())
            file.createNewFile();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            String[] split = scanner.nextLine().split(";");
            Vehicle vehicle = new Vehicle(split[0], split[1], split[2], Integer.valueOf(split[3]), Integer.valueOf(split[4]), split[5]);
            vehicles.offer(vehicle);
        }
        scanner.close();
        return vehicles;
    }
}
