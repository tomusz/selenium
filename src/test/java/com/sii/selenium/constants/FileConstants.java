package com.sii.selenium.constants;

import java.nio.file.Path;

public class FileConstants {

    private static final Path PATH_TO_SOME_FILE = Path.of("src/main/resources/someFile.txt");

    public static Path getPathToSomeFile() {
        return PATH_TO_SOME_FILE;
    }

}
