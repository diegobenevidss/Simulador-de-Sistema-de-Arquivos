
import java.util.*;

class Journal {
    private List<String> logs = new ArrayList<>();
    public void log(String operation) {
        logs.add(operation);
    }
    public void printLogs() {
        for (String log : logs) {
            System.out.println(log);
        }
    }
}
