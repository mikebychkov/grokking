package io;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathWorks {

    public static void main(String[] args) {
        Path p = Paths.get(".");
        System.out.println(p.toAbsolutePath().toString());
    }
}
