// leetcode 731. My Calendar II ?

class MyCalendarTwo {

    List<int[]> bookings;
    List<int[]> overlapBookings;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlapBookings = new ArrayList<>();
    }

    // overlap check for [start, end)
    public boolean overlap(int[] i1, int s2, int e2) {
        int s1 = i1[0];
        int e1 = i1[1];
        return Math.min(e1, e2) > Math.max(s1, s2);
    }

    public boolean book(int startTime, int endTime) {

        // If overlaps with any double book interval triple booking 
        for (int i = 0; i < overlapBookings.size(); i++) {
            if (overlap(overlapBookings.get(i), startTime, endTime)) {
                return false;
            }
        }

        // Create the new double book intervals
        for (int i = 0; i < bookings.size(); i++) {
            if (overlap(bookings.get(i), startTime, endTime)) {
                overlapBookings.add(new int[]{
                    Math.max(bookings.get(i)[0], startTime),
                    Math.min(bookings.get(i)[1], endTime)
                });
            }
        }

        //Add the  booking
        bookings.add(new int[]{startTime, endTime});
        return true;
    }
}
