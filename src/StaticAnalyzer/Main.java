package StaticAnalyzer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static StaticAnalyzer.LogType.*;

public class Main {
    public static void main(String[] args) {


        List<Log> logs = List.of(
                new Log(ERROR,"Opearation halted",200),
                new Log(INFO,"User login",120),
                new Log(WARN,"Slow request",600),
                new Log(ERROR,"DB connection",900),
                new Log(ERROR,"Lost connecion",95),
                new Log(INFO,"Be patient",160),
                new Log(WARN,"Slow internet connection",1200)



        );


        long errLogs = logs.stream()
                .filter(n->n.getType()==ERROR)
                .count();


        logs.stream()
                .filter(n->n.getDuration()>500)
                .forEach(msg-> System.out.println("Message: " + msg.getMessage()));

        double average = logs.stream()
                .mapToDouble(Log::getDuration)
                .average()
                .orElse(0.0);

        Map<LogType,Long> statistics = logs.stream()
                .collect(
                        Collectors.groupingBy(
                                Log::getType,
                                Collectors.counting()
                        )
                );

        statistics.forEach(((logType, aLong) -> System.out.println(logType + " -> " + aLong)));

    }
}
