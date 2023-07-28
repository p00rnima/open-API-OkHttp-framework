package com.openapi.fcds.test.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.experimental.UtilityClass;

import java.io.File;

@UtilityClass
public class FileHelper {

    public void writeData(String path, Object obj) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        File file;
        try {
            file = new File(path);
            mapper.writeValue(file, obj);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to write data in YAML file: " + path, e.fillInStackTrace());
        }
    }

    public Object readData(String path, Class className) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        File file;
        try {
            file = new File(path);
            return mapper.readValue(file, className);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to write data in YAML file: " + path, e.fillInStackTrace());
        }
    }

}
