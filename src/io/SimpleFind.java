package io;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class SimpleFind {

    public static void main(String[] args) {

        String pattern = "*Rail*";

        //Path path = Paths.get("C:/Projects/archive/");
        Path path = Paths.get("../archive/");

        walk(path.toFile(), pattern);
    }

    public static void walk(File file, String pattern) {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                walk(f, pattern);
            }
        } else {

//            String root = file.toPath().getRoot().toString();
//            root = root.substring(0, 2);
//            String resentPattern = root + "/**/" + pattern;

            String resentPattern = pattern;

            PathMatcher matcher = FileSystems.getDefault()
                    .getPathMatcher("glob:" + resentPattern);

            System.out.println(file.toString());
            if (matcher.matches(file.toPath().getFileName())) {
                System.out.println("HOOORAAAYYY!!!");
            }
        }
    }
}
