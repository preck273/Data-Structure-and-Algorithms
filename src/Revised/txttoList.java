package Revised;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class txttoList<T>{

    public List<T> readFileToList(String filePath, Class<T> clazz) {
        List<T> lines = new ArrayList<T>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                T item = parseLine(line, clazz);
                lines.add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lines;
    }

    private T parseLine(String line, Class<T> clazz) {
        return clazz.cast(line);
    }
}
