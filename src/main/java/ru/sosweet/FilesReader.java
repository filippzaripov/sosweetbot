package ru.sosweet;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class FilesReader {
    private final static Logger log = Logger.getLogger(FilesReader.class);

    public static Properties getProperties(String fileName) {
        Properties properties = null;
        try (FileInputStream input = new FileInputStream(fileName)) {
            properties = new Properties();
            properties.load(input);
        } catch (FileNotFoundException e) {
            log.error("Proxy file not found");
        } catch (IOException e) {
            log.error("Error while reading property file");
        }
        return properties;
    }

    public static String readText(String path) {
        try {
            byte[] result = Files.readAllBytes(Paths.get(path));
            return new String(result);
        } catch (IOException ex) {
            //todo прикрутить логер
            String err = "Ошибка при чтении файла " + path;
            log.error(err);
            throw new RuntimeException(err);
        }
    }
}
