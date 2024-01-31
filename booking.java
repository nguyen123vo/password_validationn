import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.*;


public abstract class booking {
    static Map<String, LocalDateTime[]> booking = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the hotel\n");
        boolean choose = true;
        do {
            System.out.println("Choose 1 to create booking request, 2 to view booking list, 3 to view the minimum number of room needed, 4 to exit");
            String option = scanner.nextLine();
            if (option.equals("1") || option.equals("2") || option.equals("3") || option.equals("4")) {
                switch (option) {
                    case "1":
                        createbooking();
                        break;
                    case "2":
                        System.out.println("Booking list");
                        for (String i : booking.keySet()) {
                            System.out.println("Name: " + i + "\nCheck-in time: " + booking.get(i)[0] + "\nCheck-out time: " + booking.get(i)[1]);
                        }
                        break;
                    case "3":
                        List<Long> checkInOut = new ArrayList<>();
                        for (LocalDateTime[] i : booking.values()) {
                            checkInOut.add(i[0].toEpochSecond(java.time.OffsetDateTime.now().getOffset()));
                            checkInOut.add(-i[1].toEpochSecond(java.time.OffsetDateTime.now().getOffset()));
                        }
                        Collections.sort(checkInOut, (a, b) -> Long.compare(Math.abs(a), Math.abs(b)));
                        int numberRoom = 0;
                        int minNumber = 0;
                        for (int i = 0; i < checkInOut.size(); i++) {
                            if (checkInOut.get(i) > 0) {
                                numberRoom++;
                                minNumber = Math.max(numberRoom, minNumber);
                            } else {
                                numberRoom--;
                            }
                        }
                        System.out.println("We will need at least " + minNumber + " rooms for all of our guests.");
                        break;
                    case "4":
                        System.out.println("Exit");
                        choose = false;
                        break;
                }
            } else {
                System.out.println("You must choose 1, 2, 3 or 4.");
            }
        } while (choose) ;
    }
    public static void createbooking() {
        Scanner input = new Scanner(System.in);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("name");
        String name = input.nextLine();
        int j = 0;
        for (int x= 0; x < name .length(); x++) {
            char ch = name.charAt(x);
            if (('a' <= ch && ch <= 'z') || ch == ' ') {
                j++;
            }
        }
        if (j == name.length()) {
            try {
            System.out.println("check-in time");
            System.out.println("month");
            int month1 = input.nextInt();
            System.out.println("date");
            int date1 = input.nextInt();
            System.out.println("check-out time");
            System.out.println("month");
            int month2 = input.nextInt();
            System.out.println("date");
            int date2 = input.nextInt();
            LocalDateTime checkin = LocalDateTime.of(2024, month1, date1, 14, 00, 00);
            LocalDateTime checkout = LocalDateTime.of(2024, month2, date2, 12, 00, 00 );
            if ( localDateTime.isEqual(checkin) || localDateTime.isBefore(checkin)) {
                if (checkin.isBefore(checkout)) {
                    LocalDateTime[] time = {checkin, checkout};
                    booking.put(name, time);
                } else {
                    System.out.println("Your check-in time must be to before your check-out time");
                }
            } else {
                System.out.println("Your check-in day must be after today");
            }
        } catch (DateTimeException e) {
                System.out.println("You must choose months from 1 to 12 and dates matching with the month you chose.");
            }
        }
            else {
            System.out.println("You must write your full name without accents here");
            createbooking();
        }
    }
}

