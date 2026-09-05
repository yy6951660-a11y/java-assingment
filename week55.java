final class BookingReceipt {

    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = seatNumbers.clone();
    }

    public String[] getSeatNumbers() {
        return seatNumbers.clone();
    }

    // Wither method: returns a new object
    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        String[] updatedSeats = seatNumbers.clone();
        updatedSeats[index] = newSeat;

        return new BookingReceipt(bookingId, updatedSeats);
    }
}

class GroupBookingReceipt extends BookingReceipt {

    private final int groupSize;

    public GroupBookingReceipt(
            String bookingId,
            String[] seatNumbers,
            int groupSize) {

        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }
}

public class Main {

    static String processNightlySettlement(BookingReceipt[] receipts) {

        int processed = 0;
        int skipped = 0;
        int group = 0;
        int individual = 0;

        for (BookingReceipt receipt : receipts) {

            // Null-safe check
            if (receipt == null) {
                skipped++;
                continue;
            }

            processed++;

            if (receipt instanceof GroupBookingReceipt) {
                group++;
            } else {
                individual++;
            }
        }

        return processed + " processed | "
                + skipped + " null skipped | "
                + group + " group | "
                + individual + " individual";
    }

    public static void main(String[] args) {

        BookingReceipt b =
                new BookingReceipt(
                        "CH-1001",
                        new String[]{"A1", "A2"}
                );

        // Test defensive copy
        String[] seats = b.getSeatNumbers();
        seats[0] = "X";

        System.out.println(b.getSeatNumbers()[0]);

        // Test wither
        BookingReceipt updated =
                b.withUpdatedSeat(1, "A3");

        System.out.println(
                b.getSeatNumbers()[0] + ", "
                + b.getSeatNumbers()[1]
        );

        System.out.println(
                updated.getSeatNumbers()[0] + ", "
                + updated.getSeatNumbers()[1]
        );

        // Test nightly settlement
        BookingReceipt[] receipts = {
            new GroupBookingReceipt(
                    "CH-2002",
                    new String[]{"B1", "B2"},
                    2
            ),
            null,
            new BookingReceipt(
                    "CH-3003",
                    new String[]{"C1"}
            )
        };

        System.out.println(
                processNightlySettlement(receipts)
        );
    }
}
