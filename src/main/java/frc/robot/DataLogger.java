// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

/** Add your docs here. */
class DataLogger {
    private FileWriter m_fileWriter = null;
    private static DataLogger m_instance = null;
    private static final String DATA_FILEPATH = "/home/lvuser/characterization_data.csv";
    
    private DataLogger() {
        try {
            m_fileWriter = new FileWriter(DATA_FILEPATH);
        } catch (IOException e) {
            System.out.println("Failed to open characterization data file.");
            e.printStackTrace();
        }
    }

    public static DataLogger getInstance() {
        if (m_instance == null) {
            m_instance = new DataLogger();
        }
        return m_instance;
    }

    public void write(String data) {
        try {
            m_fileWriter.write(data + "\n");
        } catch (IOException e) {
            System.out.println("Failed to write data file.");
            e.printStackTrace();
        }
    }

    public void saveData() {
        try {
            m_fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Failed to save data to file.");
            e.printStackTrace();
        }
    }
}