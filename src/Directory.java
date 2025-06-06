package src;

import java.util.*;

class Directory {
    private String name;
    private Directory parent;
    private Map<String, File> files = new HashMap<>();
    private Map<String, Directory> directories = new HashMap<>();

    public Directory(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
    }

    public boolean createFile(String name) {
        if (files.containsKey(name)) {
            System.out.println("Arquivo já existe: " + name);
            return false;
        }
        files.put(name, new File(name));
        return true;
    }

    public boolean deleteFile(String name) {
        if (!files.containsKey(name)) {
            System.out.println("Arquivo não encontrado: " + name);
            return false;
        }
        files.remove(name);
        return true;
    }

    public boolean copyFile(String sourceName, String destName) {
        if (!files.containsKey(sourceName)) {
            System.out.println("Arquivo de origem não encontrado: " + sourceName);
            return false;
        }
        if (files.containsKey(destName)) {
            System.out.println("Já existe um arquivo com o nome: " + destName);
            return false;
        }
        files.put(destName, new File(destName));
        return true;
    }

    public boolean createDirectory(String name) {
        if (directories.containsKey(name)) {
            System.out.println("Diretório já existe: " + name);
            return false;
        }
        directories.put(name, new Directory(name, this));
        return true;
    }

    public boolean deleteDirectory(String name) {
        if (!directories.containsKey(name)) {
            System.out.println("Diretório não encontrado: " + name);
            return false;
        }
        directories.remove(name);
        return true;
    }

    public boolean rename(String oldName, String newName) {
        if (files.containsKey(oldName)) {
            if (files.containsKey(newName)) {
                System.out.println("Já existe um arquivo com o nome: " + newName);
                return false;
            }
            File file = files.remove(oldName);
            file.setName(newName);
            files.put(newName, file);
            return true;
        } else if (directories.containsKey(oldName)) {
            if (directories.containsKey(newName)) {
                System.out.println("Já existe um diretório com o nome: " + newName);
                return false;
            }
            Directory dir = directories.remove(oldName);
            dir.setName(newName);
            directories.put(newName, dir);
            return true;
        } else {
            System.out.println("Arquivo ou diretório não encontrado: " + oldName);
            return false;
        }
    }

    public void listContents() {
        System.out.println("Arquivos:");
        for (String f : files.keySet()) System.out.println(" - " + f);
        System.out.println("Diretórios:");
        for (String d : directories.keySet()) System.out.println(" - " + d);
    }

    public Directory getSubDirectory(String name) {
        return directories.get(name);
    }

    public Directory getParent() {
        return parent;
    }

    public String getPath() {
        if (parent == null) return "/" + name;
        return parent.getPath() + "/" + name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
