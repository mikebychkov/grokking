package io;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileAbsPath {

    public static void main(String[] args) {
        File file = new File(".");
        System.out.println(file.getAbsolutePath());
        Path path = Paths.get(".");
        System.out.println(path.toAbsolutePath().toString());
    }
}
