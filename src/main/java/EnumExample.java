//An enum (short for enumeration) is a special Java type used to define a collection of constants
// (fixed set of values).

//Think of it like a list of named values that don’t change — for example, days of the week, colors, states,
// directions, etc.

enum Prime {

//    Java does not allow numbers as enum constant names.
//    Enum constants must be valid identifiers (start with a letter, no digits-only names).
//    2,7,5

    TWO(2), FIVE(5), SEVEN(7);

    private int value;

    Prime(int value) {
        this.value = value;
    }
//
//    public int getValue() {
//        return value;
//    }

}

public class EnumExample {
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {
        Day today = Day.FRIDAY;

        if (today == Day.FRIDAY) {
            System.out.println("Weekend is near!");
        }

        // Looping through values
        for (Day d : Day.values()) {
            System.out.println(d);
        }

        for (Prime p:Prime.values()){
            System.out.println(p);
        }
    }
}
