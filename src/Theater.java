
import java.io.*;
import java.util.*;

public class Theater {

    private static void bubbleSort_tickets(ArrayList<Ticket> ticket){
        Scanner input = new Scanner(System.in);
        int bottom =ticket.size()-1;
        Ticket temp;
        boolean exchanged = true;

        while (exchanged){
            exchanged=false;
            for (int i = 0; i <bottom; i++) {
                if (ticket.get(i).getPrice()>ticket.get(i+1).getPrice()){
                    temp =ticket.get(i);
                    ticket.set(i,ticket.get(i+1));
                    ticket.set(i+1,temp);
                    exchanged=true;
                }
            }
            bottom--;
        }



        double TotalPrice =0;
        System.out.println("Information of the ticket");

        for (Ticket value : ticket) {
            value.printInfo();
            System.out.println();
            TotalPrice = TotalPrice + value.getPrice();

        }
        System.out.println("Total Ticket Price :"+" $"+TotalPrice);
        System.out.println("-----------------------------------------");

        System.out.println();
        System.out.print("Print Ticket Information Y/N:");
        String option = input.next();

        switch (option){
            case "Y" :
                System.out.println();
                break;

        }



    }

    private static void show_tickets_info(ArrayList<Ticket> ticket) {
        Scanner input =new Scanner(System.in);
        double TotalPrice =0.0;
        System.out.println("Information of the ticket ");

        for (Ticket value : ticket) {
            value.printInfo();
            System.out.println();
            TotalPrice = TotalPrice + value.getPrice();

        }
        System.out.println("Total Ticket Price :"+"$"+TotalPrice);
        System.out.println("----------------------------------------");

        System.out.println();
        System.out.print("Go Back To Main Menu (G) :");
        String option = input.next();

        switch (option){
            case "G" :
                System.out.println();
                break;

        }

    }


    private static void load_File(int[] row1, int[] row2, int[] row3) throws IOException {

      File filename =new File("MyFile.txt");
        int num =0;
        String[] array= new String[3];
        Scanner file_reader;
        try{
            file_reader=new Scanner(filename);
            while (file_reader.hasNextLine()){
                array[num] =file_reader.nextLine();
                num++;
            }

        }catch(FileNotFoundException e){
            System.out.println("File not found.");
            return;
        }

        for (int i = 0; i < row1.length; i++) {
            row1[i]=Character.getNumericValue(array[0].charAt(i));
        }

        for (int i = 0; i < row2.length; i++) {
            row2[i]=Character.getNumericValue(array[1].charAt(i));
        }

        for (int i = 0; i < row3.length; i++) {
            row3[i]=Character.getNumericValue(array[2].charAt(i));
        }



        System.out.println(Arrays.toString(row1));
        System.out.println(Arrays.toString(row2));
        System.out.println(Arrays.toString(row3));




    }



    private static void save_File(int[] row1, int[] row2, int[] row3) throws IOException {
       Scanner input =new Scanner(System.in);
        FileWriter myWriter = new FileWriter("MyFile.txt");
        PrintWriter writer =new PrintWriter(myWriter);


        for (int j : row1) {
            writer.print(j);
        }
        writer.println();


        for (int j : row2) {
            writer.print(j);
        }
        writer.println();


        for (int j : row3) {
            writer.print(j);
        }
        writer.close();

        System.out.println("Row information is Saved");
        System.out.print("Go Back To the Main Menu (G) :");

        String option = input.next();

        switch (option){
            case "G" :
                System.out.println();

                break;

        }


    }

    private static void show_Available(int[] row1, int[] row2, int[] row3) {
        Scanner input =new Scanner(System.in);
        System.out.println("***Available Seats***");
        System.out.print("Available Seats in Row 1 : ");
        for (int i = 0; i <row1.length; i++) {
            if (row1[i]!=1){
                System.out.print((i+1)+",");
            }
        }

        System.out.println("\b");
        System.out.println();
        System.out.print("Available Seats in Row 2 : ");
        for (int i = 0; i <row2.length; i++) {
            if (row2[i]!=1){
                System.out.print((i+1)+",");
            }

        }

        System.out.println("\b");
        System.out.println();
        System.out.print("Available Seats in Row 3 : ");
        for (int i = 0; i <row3.length; i++) {
            if (row3[i]!=1){
                System.out.print((i+1)+",");
            }
        }

        System.out.println("\b");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        System.out.print("Do You Want Go Back (Y/N) :");
        String option = input.next();


        switch (option){
            case "Y" :
                System.out.println();
                break;

        }




    }

    private static void cancel_ticket(int[] row1, int[] row2, int[] row3, ArrayList<Ticket> ticket) {
        Scanner input =new Scanner(System.in);

        while(true){
            System.out.println("Enter Your Row Number : ");
            int row = input.nextInt();

            if (row==1){
                System.out.print("Enter Your a Seat Number : ");
                int seatNumber =input.nextInt();
                if (isCorrect(row1,seatNumber)){
                    System.out.println("Your seat Number is Correct.");
                    System.out.print("Do You Want to Cancel Your Ticket (Y/N) :");
                    String option =input.next();
                    if (option.equals("Y")){
                        cancelTicket(1,row1,seatNumber,ticket);
                        System.out.println();
                        break;
                    }else {
                        break;
                    }

                }else{
                    System.out.println("Incorrect Row & Seat Number. Please Try Again");
                    System.out.print("Do You Want to Try Again (T) Or Go Back To Menu (G) :");
                    String option = input.next();
                    if (option.equals("G")){

                        break;
                    }
                    System.out.println();
                }
            }else if (row==2){
                System.out.print("Enter Your a Seat Number : ");
                int seatNumber =input.nextInt();

                if (isCorrect(row2,seatNumber)){
                    System.out.println("Your seat Number is Correct.");
                    System.out.print("Do You Want to Cancel Your Ticket (Y/N) :");
                    String option =input.next();
                    if (option.equals("Y")){
                        cancelTicket(2,row2,seatNumber,ticket);

                        break;
                    }else{
                        break;
                    }

                }else{
                    System.out.println("Incorrect Row & Seat Number. Please Try Again");
                    System.out.print("Do You Want to Try Again (T) Or Go Back To Menu (G) :");
                    String option = input.next();
                    if (option.equals("G")){
                        break;
                    }
                    System.out.println();
                }

            }else if(row==3){
                System.out.print("Enter Your Seat Number : ");
                int seatNumber =input.nextInt();

                if (isCorrect(row3,seatNumber)){
                    System.out.println("Your seat Number is Correct.");
                    System.out.print("Do You Want Cancel Your Ticket (Y/N) :");
                    String option =input.next();
                    if (option.equals("Y")){
                        cancelTicket(3,row3,seatNumber,ticket);
                        break;
                    }else{
                        break;
                    }
                }else{
                    System.out.println("Incorrect Row & Seat Number. Please Try Again");
                    System.out.print("Do You Want to Try Again (T) Or Go Back To Menu (G) :");
                    String option = input.next();
                    if (option.equals("G")){
                        break;
                    }
                    System.out.println();
                }

            }else{
                System.out.println("Incorrect Row..Try Again..");
                System.out.println();
            }

        }
    }

    private static void cancelTicket(int row,int[] rowA, int seatNumber, ArrayList<Ticket> ticket) {
        for (int i = 0; i < rowA.length; i++) {
            if (i == seatNumber-1){
                for (int j = 0; j <ticket.size(); j++) {
                    if (row==ticket.get(j).getRow()||seatNumber == ticket.get(j).getSeat()){

                        ticket.remove(j);
                        rowA[i] =0;
                        System.out.println("Thank You.");
                        System.out.println();
                    }
                }

            }
        }
    }

    private static boolean isCorrect(int[] row,int seatNumber) {
        for (int i = 0; i <row.length; i++) {
            if (i==seatNumber-1){
                if (row[i] == 1){
                    return true;
                }

            }
        }
        return false;
    }

    private static void print_Seating_Area(int[] row1, int[] row2, int[] row3) {
        Scanner input =new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("*           STAGE         *");
        System.out.println("---------------------------");


        for (int i = 0; i <=7; i++) {
           if (i<=6){
               System.out.print(" ");

           }
        }

        for (int i = 0; i < row1.length; i++) {

            if (i!=row1.length/2){
                if (row1[i]!=0){
                    System.out.print("X");
                }else {
                    System.out.print("O");
                }
            }else{
                System.out.print(" ");
                if (row1[i]!=0){
                    System.out.print("X");
                }else {
                    System.out.print("O");
                }

            }


        }
        System.out.println();
        System.out.println();

        for (int i = 0; i <=5; i++) {
            if (i<=4){
                System.out.print(" ");

            }
        }


        for (int i = 0; i < row2.length; i++) {
            if (i!=row2.length/2){

                if (row2[i]!=0){
                    System.out.print("X");
                }else {
                    System.out.print("O");
                }
            }else{
                System.out.print(" ");
                if (row2[i]!=0){
                    System.out.print("X");
                }else {
                    System.out.print("O");
                }

            }
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i <=3; i++) {
            if (i<=2){
                System.out.print(" ");

            }
        }

        for (int i = 0; i < row3.length; i++) {
            if (i!=row3.length/2){
                if (row3[i]!=0){
                    System.out.print("X");
                }else {
                    System.out.print("O");
                }
            }else{
                System.out.print(" ");
                if (row3[i]!=0){
                    System.out.print("X");
                }else {
                    System.out.print("O");
                }
            }

        }
        System.out.println();
        System.out.println();
        System.out.print("Go Back To Main Menu (G) :");
        String option = input.next();

        switch (option){
            case "G" :
                System.out.println();
                break;
        }
    }
    public static void buy_ticket(int[] row1, int[] row2, int[] row3, ArrayList<Ticket> ticket) {
        Scanner input =new Scanner(System.in);


        while(true) {
            System.out.println();
            System.out.print("Enter the Row Number : ");
            int row = input.nextInt();
            System.out.println();
            System.out.print("Enter a Seat Number : ");
            int seatNumber =input.nextInt();

            System.out.println();

            if (row == 1 && (seatNumber<=12 && seatNumber>0 )){
                if (isAvailable(row1,seatNumber)){
                    occupiedTicket(1,row1,seatNumber,ticket);
                    System.out.print("Do You Want to Buy Another Ticket (Y/N) :");

                    String option = input.next();
                    if (option.equals("N")){
                        System.out.println("<<-------------------------------------->>");
                        break;
                    }
                    System.out.println("<<-------------------------------------->>");


                }else{
                    System.out.println("Seat Number "+seatNumber+" Not Available");
                }

            }else if(row == 2 && (seatNumber<=16 && seatNumber>0)){
                if (isAvailable(row2,seatNumber)){
                    occupiedTicket(2,row2,seatNumber,ticket);
                    System.out.print("Do You Want to Buy Another Ticket (Y/N) :");

                    String option = input.next();
                    if (option.equals("N")){
                        System.out.println("<<-------------------------------------->>");
                        break;
                    }
                    System.out.println("<<-------------------------------------->>");

                }else{
                    System.out.println("Seat Number "+seatNumber+" Not Available");
                }


            }else if (row == 3 && (seatNumber<=20 && seatNumber>0)){
                if (isAvailable(row3,seatNumber)){
                    occupiedTicket(3,row3,seatNumber,ticket);
                    System.out.print("Do You Want to Buy Another Ticket (Y/N) :");

                    String option = input.next();
                    if (option.equals("N")){
                        System.out.println("<<-------------------------------------->>");
                        break;
                    }
                    System.out.println("<<-------------------------------------->>");

                }else{
                    System.out.println("Seat Number "+seatNumber+" Not Available");
                }

            }else {
                System.out.println("Incorrect Row And Seat..Try Agian.");
            }





        }

    }

    static void occupiedTicket(int rowNum,int[] row, int seatNumber, ArrayList<Ticket> ticket) {

        Scanner input =new Scanner(System.in);
        for (int i = 0; i < row.length; i++) {
            if (i == (seatNumber-1)) {
                System.out.println();
                System.out.println("<<<<<Please Enter Your Details Below>>>>> ");
                System.out.print("Enter Your name :");
                String name = input.next();
                System.out.println();
                System.out.print("Enter Your Surname  :");
                String surname = input.next();
                System.out.println();
                System.out.print("Enter Your Email :");
                String email =input.next();
                System.out.println();
                if (rowNum==1){
                    Ticket ticket1 = new Ticket(rowNum,seatNumber,30,new Person(name,surname,email));
                    ticket.add(ticket1);
                    row[seatNumber - 1] = 1;
                    System.out.println("Your Seat is Booked.Thank You!!!");
                    System.out.println();
                    System.out.println();
                }else if (rowNum==2){
                    Ticket ticket1 = new Ticket(rowNum,seatNumber,20,new Person(name,surname,email));
                    ticket.add(ticket1);
                    row[seatNumber - 1] = 1;
                    System.out.println("Your Seat is Booked.Thank You!!!");
                    System.out.println();
                    System.out.println();
                }else if (rowNum==3){
                    Ticket ticket1 = new Ticket(rowNum,seatNumber,10,new Person(name,surname,email));
                    ticket.add(ticket1);
                    row[seatNumber - 1] = 1;
                    System.out.println("Your Seat is Booked.Thank You!!!");
                    System.out.println();
                    System.out.println();
                }

            }
        }
    }

    static boolean isAvailable(int[] row, int seatNumber) {
        for (int i = 0; i <row.length; i++) {
            if (row[seatNumber-1]==0){

                return true;

            }
        }
        return false;
    }


    public static void main(String[] args) throws IOException {

        ArrayList<Ticket> ticket=new ArrayList<Ticket>();

        for (int i = 0; i<ticket.size(); i++) {
            System.out.println(ticket.get(i));
        }


        int[] row1 = new int[12];
        int[] row2 = new int[16];
        int[] row3 = new int[20];


        int option;
        Scanner input= new Scanner(System.in);

        while (true) {
            System.out.println("------------------------------------------------------");
            System.out.println("*             Welcome To The New Theater             *");
            System.out.println("------------------------------------------------------");
            System.out.println();
            System.out.println("Please Select an Option :");

            System.out.println("1) Buy a Ticket");
            System.out.println("2) Print Seating Area");
            System.out.println("3) Cancel Ticket");
            System.out.println("4) List Available Seats");
            System.out.println("5) Save to File");
            System.out.println("6) Load from File");
            System.out.println("7) Print Ticket Information and Total Price");
            System.out.println("8) Sort Ticket By Price");

            System.out.println("        0)Quit");

            System.out.println("------------------------------------------------------");
            System.out.print("Enter The Option : ");
            option = input.nextInt();
            System.out.println("------------------------------------------------------");


            switch (option) {
                case 1 -> buy_ticket(row1, row2, row3, ticket);
                case 2 -> print_Seating_Area(row1, row2, row3);
                case 3 -> cancel_ticket(row1, row2, row3, ticket);
                case 4 -> show_Available(row1, row2, row3);
                case 5 -> save_File(row1, row2, row3);
                case 6 -> load_File(row1, row2, row3);
                case 7 -> show_tickets_info(ticket);
                case 8 -> bubbleSort_tickets(ticket);
                case 0 -> {
                    System.out.println("Thank You...!");
                    return;
                }
                default -> System.out.println("Invalid Option selected. ");
            }

        }


    }







}
