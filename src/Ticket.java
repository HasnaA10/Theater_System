import java.util.ArrayList;
import java.util.Comparator;

public class Ticket  {
    int row;
    int seat;
    double price;
    Person person;




    public Ticket(int row, int seatNumber, int price,Person person) {
        this.row = row;
        this.seat = seatNumber;
        this.price = price;
        this.person = person;
    }



    public void printInfo(){
        System.out.println("Person Name :"+person.getName());
        System.out.println("Person Surname :"+person.getSurname());
        System.out.println("Person Email :"+person.getEmail());
        System.out.println("Row Number :"+row);
        System.out.println("Seat Number :"+seat);
        System.out.println("Price :"+"$"+price);



    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static Comparator<Ticket> ticketPrice = new Comparator<Ticket>() {

        @Override
        public int compare(Ticket o1, Ticket o2) {
            int price1 = (int) o1.getPrice();
            int price2 = (int) o2.getPrice();
            return price1 - price2;
        }


    };


}
