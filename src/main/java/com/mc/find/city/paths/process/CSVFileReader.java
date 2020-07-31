package com.mc.find.city.paths.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class CSVFileReader {

    private static final Logger log = LoggerFactory.getLogger(CSVFileReader.class);

    public void getListOfPaths (List<String> rawList, String FILE_PATH) throws IOException {
        getFileContent(rawList, FILE_PATH);
    }

    private void getFileContent(List<String> rawList, String FILE_PATH) throws IOException {
        try (InputStream inputStream = new FileInputStream(FILE_PATH);
             InputStreamReader isr = new InputStreamReader(inputStream);
             BufferedReader br = new BufferedReader(isr)){
            String str;
            while ((str = br.readLine()) != null) {
                rawList.add(str);
            }
            log.info("RawList from ReadCSVFile : " + rawList.size());
        } catch (IOException ex) {
            log.error("Exception while reading CSV file : " + ex.getMessage());
            throw new IOException(ex);
        }
    }
}
