package org.example.services;

import java.io.FileWriter;
import java.io.IOException;

public class FileService implements IFileService {

    private String filePath;

    public FileService(String filePath) {
        this.filePath = filePath;
    }
    @Override
    public void writeToFile(String text)
    {
        try(FileWriter writer = new FileWriter(filePath, true))
        {
            writer.write(text);
        } catch (IOException e) {
            System.out.println("Проблемы с записью в файл");
        }
    }

}
