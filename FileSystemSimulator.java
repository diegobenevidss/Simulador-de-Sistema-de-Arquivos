import java.util.*;

public class FileSystemSimulator {
    private static Directory root = new Directory("root");
    private static Journal journal = new Journal();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String command;
        System.out.println("Bem-vindo ao Simulador de Sistema de Arquivos!");
        while (true) {
            System.out.print(">> ");
            command = scanner.nextLine();
            if (command.equalsIgnoreCase("exit")) break;
            processCommand(command);
        }
        System.out.println("\nLogs de operações:");
        journal.printLogs();
    }

    private static void processCommand(String command) {
        String[] parts = command.split(" ");
        switch (parts[0]) {
            case "mkdir":
                if (root.createDirectory(parts[1])) {
                    journal.log("Diretório criado: " + parts[1]);
                } else {
                    journal.log("Falha ao criar diretório: " + parts[1]);
                }
                break;
            case "touch":
                if (root.createFile(parts[1])) {
                    journal.log("Arquivo criado: " + parts[1]);
                } else {
                    journal.log("Falha ao criar arquivo: " + parts[1]);
                }
                break;
            case "rm":
                if (root.deleteFile(parts[1])) {
                    journal.log("Arquivo removido: " + parts[1]);
                } else {
                    journal.log("Falha ao remover arquivo: " + parts[1]);
                }
                break;
            case "rmdir":
                if (root.deleteDirectory(parts[1])) {
                    journal.log("Diretório removido: " + parts[1]);
                } else {
                    journal.log("Falha ao remover diretório: " + parts[1]);
                }
                break;
            case "ls":
                root.listContents();
                journal.log("Conteúdo do diretório raiz listado");
                break;
            case "rename":
                if (root.rename(parts[1], parts[2])) {
                    journal.log("Renomeado: " + parts[1] + " para " + parts[2]);
                } else {
                    journal.log("Falha ao renomear: " + parts[1] + " para " + parts[2]);
                }
                break;
            default:
                System.out.println("Comando inválido!");
        }
    }
}
