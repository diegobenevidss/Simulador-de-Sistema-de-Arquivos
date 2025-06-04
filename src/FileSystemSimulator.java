package src;

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
            command = scanner.nextLine().trim();
            if (command.equalsIgnoreCase("exit")) break;
            processCommand(command);
        }
        System.out.println("\nLogs de operações:");
        journal.printLogs();
    }

    private static void processCommand(String command) {
        String[] parts = command.split("\\s+");
        switch (parts[0]) {
            case "mkdir":
                if (parts.length < 2) {
                    System.out.println("Uso: mkdir <nome_diretorio>");
                    return;
                }
                if (root.createDirectory(parts[1])) {
                    journal.log("Diretório criado: " + parts[1]);
                } else {
                    journal.log("Falha ao criar diretório: " + parts[1]);
                }
                break;

            case "touch":
                if (parts.length < 2) {
                    System.out.println("Uso: touch <nome_arquivo>");
                    return;
                }
                if (root.createFile(parts[1])) {
                    journal.log("Arquivo criado: " + parts[1]);
                } else {
                    journal.log("Falha ao criar arquivo: " + parts[1]);
                }
                break;

            case "rm":
                if (parts.length < 2) {
                    System.out.println("Uso: rm <nome_arquivo>");
                    return;
                }
                if (root.deleteFile(parts[1])) {
                    journal.log("Arquivo removido: " + parts[1]);
                } else {
                    journal.log("Falha ao remover arquivo: " + parts[1]);
                }
                break;

            case "rmdir":
                if (parts.length < 2) {
                    System.out.println("Uso: rmdir <nome_diretorio>");
                    return;
                }
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
                if (parts.length < 3) {
                    System.out.println("Uso: rename <nome_antigo> <novo_nome>");
                    return;
                }
                if (root.rename(parts[1], parts[2])) {
                    journal.log("Renomeado: " + parts[1] + " para " + parts[2]);
                } else {
                    journal.log("Falha ao renomear: " + parts[1] + " para " + parts[2]);
                }
                break;

            case "cp":
                if (parts.length < 3) {
                    System.out.println("Uso: cp <arquivo_origem> <arquivo_destino>");
                    return;
                }
                if (root.copyFile(parts[1], parts[2])) {
                    journal.log("Arquivo copiado: " + parts[1] + " para " + parts[2]);
                } else {
                    journal.log("Falha ao copiar arquivo: " + parts[1] + " para " + parts[2]);
                }
                break;

            default:
                System.out.println("Comando inválido!");
        }
    }
}