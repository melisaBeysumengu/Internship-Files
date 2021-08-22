package Week1.Day2.Example1;

public class Main {

    public static void main(String[] args) {


        Bus bus1 = new Bus(Destination.Ankara);
        bus1.insertPassenger(new Passenger("Ali", Destination.Ankara));
        bus1.insertPassenger(new Passenger("Ayşe", Destination.Istanbul));
        bus1.insertPassenger(new Passenger("Mehmet", Destination.Ankara));
        bus1.insertPassenger(new Passenger("Sedef", Destination.Ankara));

        bus1.insertMultiplePassenger(new Passenger("Ali", Destination.Ankara),
                new Passenger("Ayşe", Destination.Istanbul),
                new Passenger("Mehmet", Destination.Ankara),
                new Passenger("Sedef", Destination.Ankara),
                new Passenger("Sedef", Destination.Ankara),
                new Passenger("Sedef", Destination.Adana));

    }
}
