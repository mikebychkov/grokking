package io;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class PathMatcherExample {

    public static void main(String[] args) {
        FileSystem fileSystem = FileSystems.getDefault();
        PathMatcher pathMatcher = fileSystem.getPathMatcher("glob:C:/**/*Rail*");
        Path path = Paths.get("C:/Projects/archive/Class Rail.java");
        System.out.println(pathMatcher.matches(path));
    }
}
