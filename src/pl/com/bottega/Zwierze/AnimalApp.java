package pl.com.bottega.Zwierze;


import java.util.Scanner;

public class AnimalApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Animal[] animals = new Animal[6];
        animals[0] = new Animal("Lew", new LandMoveStrategy(), new MeatEatStrategy());
        animals[1] = new Animal("Kon", new LandMoveStrategy(), new VegeEatStrategy());
        animals[2] = new Animal("Mewa", new AirMoveStrategy(), new MeatEatStrategy());
        animals[3] = new Animal("Sokol", new AirMoveStrategy(), new MeatEatStrategy());
        animals[4] = new Animal("Wieloryb", new WaterMoveStrategy(), new VegeEatStrategy());
        animals[5] = new Animal("Rekin", new WaterMoveStrategy(), new MeatEatStrategy());

        while (true) {
            System.out.println("Zwierzęta w encyklopedii: \n"  +
           " 1. Lew \n" +
           " 2. Koń \n" +
           " 3. Mewa \n" +
           " 4. Sokół \n" +
           " 5. Wieloryb \n" +
           " 6. Rekin \n"+
           " Wybierz zwierzę ");
            int number = scanner.nextInt();
            if (number <1 || number > animals.length)
                System.out.println("Nieprawidlowy numer");
            else
                animals[number -1].presentYourSelf();
        }
    }
}


