import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Java 8

public class Demo2 {
    public static void main(String[] arg){
//        System.out.println(calcAvg(10));
        System.out.println(calcAvg(10,20).get()); // triple dot function - if we have value otherwise throws exception
        System.out.println(calcAvg().get()); // triple dot function - getting error

        doDateAndTime();


    }
//    public static void a(){}
    public static void doPartitioning(){
        Map<Boolean,List<String>> map = Stream.of("john","peter","john","alan")
                .collect(
                        Collectors.partitioningBy(s->s.startsWith("a"))
                );
        System.out.println(map);

        Map<Boolean, Set<String>> map1 = Stream.of("john","peter","john","alan")
                .collect(
                        Collectors.partitioningBy(s->s.startsWith("a"),Collectors.toSet())
                );
        System.out.println(map1);
    }

    public static void doGroupingBy(){
        Map<Boolean,List<String>> map = Stream.of("john","peter","john","alan")
                .collect(
                        Collectors.groupingBy(s->s.startsWith("a"))
                );
        System.out.println(map);

        Map<Object, Set<String>> map1 = Stream.of("john","peter","john","alan")
                .collect(
                        Collectors.groupingBy(String::length,
                                TreeMap::new,
                                Collectors.toSet()) // removing duplicates and grouping by length
                );
        System.out.println(map1);
    }

    public static void doCollectToMap(){
        Map< Integer,String> map = Stream.of("john","b","as","a","bb","peter","d","c","peter","alan")
                .collect(
                        Collectors.toMap(
                                String::length,
                                s -> s,
                                (s1,s2) -> s1+","+s2,
                                TreeMap::new // ()->new TreeMap()
                        )
                );
        System.out.println(map);
    }

    public static void doJoining(){
        String s = Stream.of("john","b","as","a","bb","peter","d","c","peter","alan").collect(Collectors.joining());
        System.out.println(s);
    }

    public static void doAvg(){
        Double s = Stream.of("john","b","as","a","bb","peter","d","c","peter","alan").collect(Collectors.averagingDouble(si->si.length()));
        System.out.println(s);
    }

    public static Optional<Double> calcAvg(int... arr){ // triple dot operator accepting array as input
        System.out.println("triple");

        if(arr.length == 0) return Optional.of((double) 0);

        int sum=0;
        for (int i:arr) sum+=i;

        return Optional.of((double) sum/arr.length);
    }

    public static Optional<Double> calcAvg(int i){ //only integer is input
        System.out.println("normal");
        return null;
    }

    public static void doTernaryOperation(){
        String param="doll";

//        if(param==null){
//            Optional.empty();
//        }else {
//            Optional.of(param);
//        }
//        Optional op = param==null? Optional.empty() : Optional.of(param)
        Optional op=Optional.ofNullable(param);
        System.out.println(op);
    }

    public static void doDateAndTime(){
        Date date = new Date();
        System.out.println("Current date: " + date);

        Calendar calendar = Calendar.getInstance();
        System.out.println("Current date and time: " + calendar.getTime());

        // Get specific parts
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Months are 0-based
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("Date: " + day + "/" + month + "/" + year);

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        System.out.println("Formatted DateTime: " + formattedDateTime);

        //difference

        LocalDate l1= LocalDate.of(2024,2,17);
        LocalDate l2=LocalDate.of(2025,4,19);
        long l = ChronoUnit.DAYS.between(l1,l2);
        System.out.println(l);


        Date date1 = new Date();
        LocalDate localDate = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("LocalDate: " + localDate);

        // LocalDate to Date
        Date dateAgain = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println("Date: " + dateAgain);

        ZonedDateTime time = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(time.format(DateTimeFormatter.ISO_DATE_TIME));

        //Completable Future, Completable Stage -> multi thread
    }

}
