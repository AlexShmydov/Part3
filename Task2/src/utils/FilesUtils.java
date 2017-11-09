package utils;

import settings.SettingsValues;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesUtils {

    public static List<String[]> readFromFile(String pathToFile) {
        List<String[]> parameters = new ArrayList<>();
        try (FileReader reader = new FileReader(pathToFile)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.contains(SettingsValues.SEPARATOR)) {
                    bufferedReader.close();
                    return null;
                }
                parameters.add(line.split(SettingsValues.SEPARATOR));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return parameters;
    }

    public static void writeInFile(String pathToFile, List<String> data) {
        try {
            Files.write(Paths.get(pathToFile), data, Charset.forName(SettingsValues.DEFAULT_CHARSET));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getFileNameWithoutExt(String pathToFile) {
        File tempFile = new File(pathToFile);
        return tempFile.getName().substring(0, tempFile.getName().lastIndexOf('.'));
    }

    public static boolean checkPathIsCorrect(String pathToFile) {
        Path tempFile = Paths.get(pathToFile);
        return Files.isRegularFile(tempFile)
                & Files.isReadable(tempFile)
                & Files.isExecutable(tempFile);
    }

    public static boolean isFile(String pathToFile) {
        return new File(pathToFile).isFile();
    }

    public static boolean checkFilesExisting(String pathToFile) {
        return new File(pathToFile).exists();
    }
}
