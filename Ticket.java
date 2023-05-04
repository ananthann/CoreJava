import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
public class Ticket
{
    private String bookingDate;
    private String bookingTime;
    private Integer numberOfSeats;
    private String seats="Your seats are ";
    Scanner sc=new Scanner(System.in);
    private static Map<String, Integer[]> totalSeat =new LinkedHashMap<>();
    protected static Map<Integer,String>showTimes= new HashMap<>();
    static Map<Long,Ticket> customersAndTicket=new HashMap<>();
    public void addSeats(){
        showTimes.put(1,"09:30");
        showTimes.put(2,"11:30");
        showTimes.put(3,"12:30");
        showTimes.put(4,"17:30");
        showTimes.put(5,"20:30");

        Integer[] E1=new Integer[8];
        Integer[] E2=new Integer[8];
        Integer[] S1=new Integer[5];
        Integer[] S2=new Integer[5];
        Integer[] S3=new Integer[5];
        Integer[] G1=new Integer[2];
        Integer[] G2=new Integer[2];

        totalSeat.put("E1",E1);
        totalSeat.put("E2",E2);
        totalSeat.put("S1",S1);
        totalSeat.put("S2",S2);
        totalSeat.put("S3",S3);
        totalSeat.put("G1",G1);
        totalSeat.put("G2",G2);
        totalSeat.forEach((key, value)->{
            for(int i=0;i<value.length;i++)
            {
                value[i]=i+1;
            }
        });
    }
    public void ticketReservationFirstPage() throws IOException {
        System.out.println("Book ticket for your cinema");
        System.out.println("1. View Seats");
        System.out.println("2. BookTicket");
        System.out.println("3. Cancel Ticket");
        Integer options = sc.nextInt();
        if (options.equals(1))
        {
            viewSeat();
        }
        if (options.equals(2))
        {
            checkDateAndTime();
        }
        if (options.equals(3))
        {
            cancelTicket();
        }
    }
    public void checkDateAndTime() throws IOException {
        Ticket ticket=new Ticket();
        String content="Show Details " +
                "Date : ";
        System.out.println("enter the date u need to book ticket : yyyy-mm-dd");
         ticket.bookingDate=sc.next();

        System.out.println(ticket.bookingDate);
        LocalDate bookDate=LocalDate.parse(ticket.bookingDate);
        if (bookDate.equals(LocalDate.now())==false)
        {
            System.out.println("Tickets can only book on current date");
            checkDateAndTime();
        }
        else {
            content+=ticket.bookingDate+" " +
                    "Time : ";
            System.out.println("enter the time u need to book ticket : hh:mm");
            showTimes.forEach((key, value) -> {
                System.out.print(key + ". ");
                System.out.println(value);
            });
            ticket.bookingTime = sc.next();
            content += ticket.bookingTime + " " +
                    "Number of seats : ";
            System.out.println(ticket.bookingTime);
            LocalTime yourShowTime = LocalTime.parse(ticket.bookingTime);
            if (LocalTime.now().isAfter(yourShowTime) || (showTimes.containsValue(ticket.bookingTime) == false)
                    || yourShowTime.minusHours(2).minusMinutes(30).isAfter
                    (LocalTime.now())) {
                System.out.println("tickets can only be booked 2hours 30 minutes before the show time");
            } else {
                bookTicket(ticket, content);
            }
        }
    }
    public void bookTicket(Ticket ticket,String content) throws IOException {
        Customer customer=new Customer();
        Customer c=customer.addCustomerDetails();
        Integer amnt=0;
        System.out.println("enter the number of seats u need to book");
        ticket.numberOfSeats=sc.nextInt();
        content+=ticket.numberOfSeats+" " +
                "Seats : ";
        System.out.println(ticket.numberOfSeats);
        if (ticket.numberOfSeats>4)
        {
            System.out.println("Maximum 4 seats is only allowed");
        }
        else
        {
            for (int i = 0; i < ticket.numberOfSeats; i++) {
                System.out.println("enter the circle('E1,E2,S1,S2,S3,G1,G2')");
                String circle=sc.next();
                if (circle.equals("S1")||circle.equals("S2"))
                {
                    amnt+=120;
                }
                if (circle.equals("E1")||circle.equals("E2")||circle.equals("S3"))
                {
                    amnt+=200;
                }
                if (circle.equals("G1")||circle.equals("G2"))
                {
                    amnt+=350;
                }
                ticket.seats+=circle+" ";
                System.out.println("enter the seat number");
                Integer seatNumber= sc.nextInt();
                content+=circle+" "+seatNumber+",";
                ticket.seats+=seatNumber+",";
                Integer[] array= totalSeat.get(circle);
                if (array[seatNumber-1].equals(0))
                {
                    System.out.println("This seat is already booked");
                }
                else
                {
                    array[seatNumber-1]=0;
                }
                totalSeat.replace(circle, totalSeat.get(circle),array);
            }
            System.out.println("Total amount is : "+amnt);
            File file=new File(c.name+"_ticket_.txt");
            try
            {
                boolean value = file.createNewFile();
                if (value)
                {
                    System.out.println("New Text File is created.");
                }
                else
                {
                    System.out.println("The file already exists.");
                }
            }
            catch(Exception e) {e.getStackTrace();}
            try {
                FileWriter output = new FileWriter(c.name+"_ticket_.txt");
                output.write(content);
                System.out.println("Data is written to the file.");
                output.close();
            }
            catch (Exception e) {
                e.getStackTrace();
            }
            System.out.println(ticket.seats);
        }
        customersAndTicket.put(c.phoneNumber,ticket);
        ticketReservationFirstPage();
    }
    public void viewSeat() throws IOException {
        totalSeat.forEach((key, value)->{
            System.out.print(key+" ");
            for(int i=0;i<value.length;i++)
            {
                System.out.print(value[i]+" ");
            }
            System.out.println();
        });
        System.out.println("Booked seats-0");
        ticketReservationFirstPage();
    }
    public void cancelTicket() throws IOException {
        System.out.println("enter the phone number u entered during booking the tickets");
        Long number=sc.nextLong();
        if (customersAndTicket.containsValue(number)==false)
        {
            System.out.println("Enter phone number doesn't exists");
            System.out.println("enter the phone number u entered during booking the tickets");
             number=sc.nextLong();
        }
        Ticket ticket=customersAndTicket.get(number);
        String seat=ticket.seats.substring(15);
        Integer len;
        do {
            String getCircle=seat.substring(0,2);
            Integer[]arr=totalSeat.get(getCircle);
            seat=seat.substring(3);
            Integer getSeat= Integer.valueOf(seat.substring(0,1));
            arr[getSeat-1]=getSeat;
            totalSeat.replace(getCircle,arr);
            seat=seat.substring(2);
            len=seat.length();
        }
        while (len.equals(0)==false);
        System.out.println("your tickets have been cancelled");
        customersAndTicket.remove(number);
        ticketReservationFirstPage();
    }

    public static void main(String args[]) throws IOException {
        Ticket t=new Ticket();
        t.addSeats();
        t.ticketReservationFirstPage();
    }
}
