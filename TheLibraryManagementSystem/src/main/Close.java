package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import operations.Issue;
import persons.Person;
import publications.Publication;

/**
 * @author Fathy & Najm
 */
public class Close {

    public static void people() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("people.txt"))) {
            writer.write(Integer.toString(Data.people.size()));
            writer.newLine();
            for (Person person : Data.people) {
                writer.write(person.getClass().getSimpleName());
                writer.newLine();
                writer.write(person.getName());
                writer.newLine();
            }
        } catch (IOException exception) {
            System.out.println("The file is closed");
        }
    }

    public static void publications() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("publications.txt"))) {
            writer.write(Integer.toString(Data.publications.size()));
            writer.newLine();
            for (Publication publication : Data.publications) {
                writer.write(publication.getClass().getSimpleName());
                writer.newLine();
                writer.write(publication.getName());
                writer.newLine();
                writer.write(publication.getPublisher());
                writer.newLine();
                writer.write(Short.toString(publication.getNumberOfCopies()));
                writer.newLine();
                writer.write(Short.toString(publication.getNumberOfIssuedCopies()));
                writer.newLine();
                writer.write(Long.toString(publication.getPublishTime()));
                writer.newLine();
            }
        } catch (IOException exception) {
            System.out.println("The file is closed");
        }
    }

    public static void publicationsIssued() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("publicationsIssued.txt"))) {
            writer.write(Integer.toString(Data.publicationsIssued.size()));
            writer.newLine();
            for (Issue issue : Data.publicationsIssued) {
                writer.write(Short.toString(issue.getSearch().getID()));
                writer.newLine();
                writer.write(Long.toString(issue.getIssueDate()));
                writer.newLine();
                writer.write(Short.toString(issue.getStudentID()));
                writer.newLine();
            }
        } catch (IOException exception) {
            System.out.println("The file is closed");
        }
    }
}
