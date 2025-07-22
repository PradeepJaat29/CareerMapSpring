package com.career.map.utils;

import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class RoadmapExporter {

    private static final String OUTPUT_DIR = "export";
    private static final String OUTPUT_FILE = OUTPUT_DIR + "/roadmap.txt";

    public void exportRoadmap(String name, String career, String goal, String[] resources) {
        try {
            // ✅ Ensure the export/ directory exists
            File dir = new File(OUTPUT_DIR);
            if (!dir.exists()) {
                dir.mkdirs(); // create export/ folder if it doesn't exist
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
                writer.write("Career Roadmap for: " + name + "\n");
                writer.write("Suggested Career: " + career + "\n");
                writer.write("Goal: " + goal + "\n\n");
                writer.write("Recommended Resources:\n");

                for (String res : resources) {
                    writer.write("- " + res + "\n");
                }

                writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace(); // You can log this instead in production
        }
    }
}
