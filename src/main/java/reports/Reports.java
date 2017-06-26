package reports;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Reports {
    public List<ExamResult> getExamResults(String firstName, String lastName, Session session) {
        String query = "select new reports.ExamResult(s.lastName, sj.name, e.grade) " +
                "from Exam e, Student s, Subject sj " +
                "where e.student.id = s.id and e.subject.id = sj.id " +
                "and s.firstName = :firstName and s.lastName = :lastName ";

        Query hibernateQuery = session.createQuery(query);
        hibernateQuery.setParameter("firstName", firstName);
        hibernateQuery.setParameter("lastName", lastName);

        return hibernateQuery.getResultList();
    }

    public List<ExamResult> getExamResultsLight(String firstName, String lastName, Session session) {
        String query = "select new reports.ExamResult(e.student.lastName, e.subject.name, e.grade) " +
                "from Exam e " +
                "where e.student.firstName = :firstName and e.student.lastName = :lastName ";

        Query hibernateQuery = session.createQuery(query);
        hibernateQuery.setParameter("firstName", firstName);
        hibernateQuery.setParameter("lastName", lastName);

        return hibernateQuery.getResultList();
    }
}
