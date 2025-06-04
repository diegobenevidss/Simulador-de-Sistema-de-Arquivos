package src;

import java.util.*;
import java.io.*;

class Journal {
    private List<String> logs = new ArrayList<>();
    private int operationCount = 1;

    public void log(String operation) {
        logs.add(operationCount++ + ". " + operation);
    }

    public void printLogs() {
        for (String log : logs) {
            System.out.println(log);
        }
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println();
            writer.println("=== Novo log de operações (" + new Date() + ") ===");

            for (String log : logs) {
                writer.println(log);
            }

            writer.println("=== Fim do log ===");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o journal no arquivo: " + e.getMessage());
        }
    }
}
