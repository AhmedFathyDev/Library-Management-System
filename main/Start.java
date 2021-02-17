package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import operations.Issue;
import persons.Admin;
import persons.Person;
import persons.Student;
import publications.Book;
import publications.Booklet;
import publications.Magazine;
import publications.Publication;

/**
 * @author Fathy & Najm
 */
public class Start {

    public static void people() {
        try (BufferedReader reader = new BufferedReader(new FileReader("people.txt"))) {
            Data.peopleIndex = Integer.parseInt(reader.readLine());
            for (int i = 0; i < Data.peopleIndex; i++) {
                String type = reader.readLine();
                Person person;
                if (type.equals("Admin")) {
                    person = new Admin();
                } else {
                    person = new Student();
                }
                person.setName(reader.readLine());
                Data.people.add(person);
            }
        } catch (IOException exception) {
            System.out.println("The file is closed");
        }
    }

    public static void publications() {
        try (BufferedReader reader = new BufferedReader(new FileReader("publications.txt"))) {
            Data.publicationsIndex = Integer.parseInt(reader.readLine());
            for (int i = 0; i < Data.publicationsIndex; i++) {
                String type = reader.readLine();
                Publication publication;
                if (type.equals(Type.BOOK.getPublicationType())) {
                    publication = new Book();
                } else if (type.equals(Type.BOOKLET.getPublicationType())) {
                    publication = new Booklet();
                } else {
                    publication = new Magazine();
                }
                publication.setName(reader.readLine());
                publication.setPublisher(reader.readLine());
                publication.setNumberOfCopies(Short.parseShort(reader.readLine()));
                publication.setNumberOfIssuedCopies(Short.parseShort(reader.readLine()));
                publication.setPublishTime(Short.parseShort(reader.readLine()));
                Data.publications.add(publication);
            }
        } catch (IOException exception) {
            System.out.println("The file is closed");
        }
    }

    public static void publicationsIssued() {
        try (BufferedReader reader = new BufferedReader(new FileReader("publicationsIssued.txt"))) {
            Data.publicationsIssuedIndex = Integer.parseInt(reader.readLine());
            for (int i = 0; i < Data.publicationsIssuedIndex; i++) {
                Issue issue = new Issue(Short.parseShort(reader.readLine()));
                issue.setIssueDate(Long.parseLong(reader.readLine()));
                issue.setStudentID(Short.parseShort(reader.readLine()));
                Data.publicationsIssued.add(issue);
            }
        } catch (IOException exception) {
            System.out.println("The file is closed");
        }
    }
}
