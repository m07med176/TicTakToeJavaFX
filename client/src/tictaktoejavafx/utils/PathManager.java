package tictaktoejavafx.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathManager {
    public static void getPath(){
    Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current absolute path is: " + s);
    }
}

