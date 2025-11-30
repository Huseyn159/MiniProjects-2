package StaticAnalyzer;

public class Log {

    private final LogType type;
    private final String message;
    private final int duration;

    public Log(LogType type, String message, int duration) {
        this.type = type;
        this.message = message;
        this.duration = duration;
    }

    public LogType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return  type  + message
                 + '\'' +
                " duration=" + duration ;
    }
}



