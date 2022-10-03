package com.revature.courses.dao;

import com.revature.courses.models.Teacher;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TeacherDAOImpl implements TeacherDAO{
    @Override
    public Teacher getByUsername(String username) {
        // i this method is where we do the actual tlaking to the database
        // in our case we will be talking to a csv file, later though we will create
        // another class to do the samer thing, but talks to an SQL database

        // create a buffered reader to talk to our db
        // we need a try catch block to make sure we don't run into a FileNotFoundException

        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/teachers.csv"));

            while ((line = br.readLine()) != null) {
                // we need to check each line to see if the username matches our entered username
                // then we should be able to send the user back to the front

                String[] info = line.split(splitBy);

                if (info[3].equals(username)) {
                    int id = Integer.parseInt(info[0]);
                    return new Teacher(id, info[1], info[2], info[3], info[4]);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
