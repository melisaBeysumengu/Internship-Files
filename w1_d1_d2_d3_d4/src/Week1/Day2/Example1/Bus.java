package Week1.Day2.Example1;

public class Bus {
    Destination destination;
    Passenger[] passengers;
    int capacity = 2;

    public Bus(Destination destination) {
        this.destination = destination;
        this.passengers = new Passenger[capacity];
    }

    void insertMultiplePassenger(Passenger... extraPassenger) {

        for (int j = 0; j < extraPassenger.length; j++) {
            for (int i = 0; i < passengers.length; i++) {
                if (extraPassenger[j].destination != destination) {
                    System.out.println("Destination does not match! "
                            + extraPassenger[j].name
                            + " could not add!");
                    i++;
                    continue;
                }

                if (passengers[i] == null) {
                    passengers[i] = extraPassenger[j];
                    extraPassenger[j].setDestination(this.destination);
                    System.out.println("Passenger inserted. " + extraPassenger[j].name);
                    i++;
                    continue;
                }
            }
        }
        System.out.println("Bus is full!");
    }

    void insertPassenger(Passenger passenger) {
        for (int i = 0; i < passengers.length; i++) {

            if (passenger.destination != destination) {
                System.out.println("Destination does not match!");
                return;
            }

            if (passengers[i] == null) {
                passengers[i] = passenger;
                passenger.setDestination(this.destination);
                System.out.println("Passenger inserted.");
                return;
            }
        }
        System.out.println("Bus is full!");
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger[] passengers) {
        this.passengers = passengers;
    }
}
