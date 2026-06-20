public class HollowWorld {

    public static boolean isWeekend(String weekday) {
        switch (weekday) {
            case "Saturday":
            case "Sunday":
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isWeekend("Saturday"));   // true
        System.out.println(isWeekend("Sunday"));     // true
        System.out.println(isWeekend("Monday"));     // false
        System.out.println(isWeekend("Tuesday"));    // false
        System.out.println(isWeekend("Wednesday"));  // false
        System.out.println(isWeekend("Thursday"));   // false
        System.out.println(isWeekend("Friday"));     // false
    }
}