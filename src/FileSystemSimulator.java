package src;

import java.util.*;

public class FileSystemSimulator {
    private static Directory root = new Directory("root", null); // root não tem pai
    private static Directory currentDirectory = root;
    private static Journal journal = new Journal();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String command;
        System.out.println("Bem-vindo ao Simulador de Sistema de Arquivos!");
        while (true) {
            System.out.print(currentDirectory.getPath() + " >> ");
            command = scanner.nextLine();
            if (command.equalsIgnoreCase("exit")) break;
            processCommand(command);
        }
        journal.saveToFile("logs.log");
        System.out.println("Logs salvos no arquivo logs.log");
    }

    private static void processCommand(String command) {
        String[] parts = command.split(" ");
        switch (parts[0]) {
            case "mkdir":
                if (parts.length < 2) {
                    System.out.println("Uso: mkdir <nome_diretorio>");
                    return;
                }
                if (currentDirectory.createDirectory(parts[1])) {
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
                if (currentDirectory.createFile(parts[1])) {
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
                if (currentDirectory.deleteFile(parts[1])) {
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
                if (currentDirectory.deleteDirectory(parts[1])) {
                    journal.log("Diretório removido: " + parts[1]);
                } else {
                    journal.log("Falha ao remover diretório: " + parts[1]);
                }
                break;

            case "ls":
                currentDirectory.listContents();
                journal.log("Conteúdo listado: " + currentDirectory.getPath());
                break;

            case "rename":
                if (parts.length < 3) {
                    System.out.println("Uso: rename <nome_antigo> <novo_nome>");
                    return;
                }
                if (currentDirectory.rename(parts[1], parts[2])) {
                    journal.log("Renomeado: " + parts[1] + " para " + parts[2]);
                } else {
                    journal.log("Falha ao renomear: " + parts[1]);
                }
                break;

            case "cp":
                if (parts.length < 3) {
                    System.out.println("Uso: cp <arquivo_origem> <arquivo_destino>");
                    return;
                }
                if (currentDirectory.copyFile(parts[1], parts[2])) {
                    journal.log("Arquivo copiado: " + parts[1] + " para " + parts[2]);
                } else {
                    journal.log("Falha ao copiar arquivo: " + parts[1]);
                }
                break;

            case "cd":
                if (parts.length < 2) {
                    System.out.println("Uso: cd <nome_diretorio ou ..>");
                    return;
                }
                Directory newDir = null;
                if (parts[1].equals("..")) {
                    if (currentDirectory.getParent() != null) {
                        newDir = currentDirectory.getParent();
                    } else {
                        System.out.println("Já está no diretório raiz.");
                        return;
                    }
                } else {
                    newDir = currentDirectory.getSubDirectory(parts[1]);
                    if (newDir == null) {
                        System.out.println("Diretório não encontrado: " + parts[1]);
                        return;
                    }
                }
                currentDirectory = newDir;
                journal.log("Alterado diretório para: " + currentDirectory.getPath());
                break;

            default:
                System.out.println("Comando inválido!");
        }
    }
}
