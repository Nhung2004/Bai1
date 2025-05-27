package Candidate;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream;
import java.util.List;

public class DBEngine {

    public static void writeToFile(String filename, List<ExperienceCandidate> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(list);
        } catch (IOException e) {
        	
            e.printStackTrace();
        }
    }

    public static List<ExperienceCandidate> readFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) { // <- Sửa dòng này
            return (List<ExperienceCandidate>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
