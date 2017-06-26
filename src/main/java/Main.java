import entity.Exam;
import entity.Student;
import entity.StudentAddress;
import entity.Subject;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.*;
import org.hibernate.query.Query;
import reports.ExamResult;
import reports.Reports;

import java.util.List;
import java.util.Random;

public class Main {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        addStudents();
        addSubjects();
        addExams();

        Reports reports = new Reports();
        List<ExamResult> examResults = reports.getExamResultsLight("John", "Doe", session);
        System.out.println(examResults);

        session.close();
        sessionFactory.close();
    }

    private static void addStudents() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            StudentAddress address = new StudentAddress("Ukraine", "Lviv", "Poshtova st.");
            Student student = new Student("John", "Doe", 22, address);
            session.save(student);

            address = new StudentAddress("USA", "NY", "Poshtova st.");
            student = new Student("Michael", "Jackson", 27, address);
            session.save(student);

            address = new StudentAddress("Canada", "Vancouver", "Poshtova st.");
            student = new Student("Sam", "Smith", 42, address);
            session.save(student);

            transaction.commit();
        }
    }

    private static void addSubjects() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            String[] names = {"Math", "Biology", "Chemistry", "Philosophy", "Physics"};
            Subject subject;

            for (String name : names) {
                subject = new Subject(name);
                session.save(subject);
            }

            transaction.commit();
        }
    }

    private static void addExams() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("from Student");
            List<Student> students = query.getResultList();

            query = session.createQuery("from Subject");
            List<Subject> subjects = query.getResultList();

            Exam exam;
            Random rand = new Random();
            for (int i = 0; i < students.size(); i++) {
                for (int j = 0; j < subjects.size(); j++) {
                    exam = new Exam(students.get(i), subjects.get(j), rand.nextInt(5) + 1);
                    session.save(exam);
                }
            }

            transaction.commit();
        }
    }
}
