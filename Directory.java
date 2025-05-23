
import java.util.*;

class Directory {
    private String name;
    private Map<String, File> files = new HashMap<>();
    private Map<String, Directory> directories = new HashMap<>();

    public Directory(String name) {
        this.name = name;
    }

    public void createFile(String name) {
        files.put(name, new File(name));
    }

    public void deleteFile(String name) {
        files.remove(name);
    }

    public void createDirectory(String name) {
        directories.put(name, new Directory(name));
    }

    public void deleteDirectory(String name) {
        directories.remove(name);
    }

    public void rename(String oldName, String newName) {
        if (files.containsKey(oldName)) {
            File file = files.remove(oldName);
            file.setName(newName);
            files.put(newName, file);
        } else if (directories.containsKey(oldName)) {
            Directory dir = directories.remove(oldName);
            dir.setName(newName);
            directories.put(newName, dir);
        }
    }

    public void listContents() {
        System.out.println("Arquivos:");
        for (String f : files.keySet()) System.out.println(" - " + f);
        System.out.println("Diretórios:");
        for (String d : directories.keySet()) System.out.println(" - " + d);
    }

    public void setName(String name) {
        this.name = name;
    }
}
