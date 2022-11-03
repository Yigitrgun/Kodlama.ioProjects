import Core.Logging.DatabaseLogger;
import Core.Logging.FileLogger;
import Core.Logging.Logger;
import Core.Logging.MailLogger;
import business.CategoryManager;
import business.CourseManager;
import business.InstructorManager;
import dataAccess.Category.HibernateCategoryDao;
import dataAccess.Course.JdbcCourseDao;
import dataAccess.Instructor.HibernateInstructorDao;
import entitites.Category;
import entitites.Course;
import entitites.Instructor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Course course = new Course(1, "Java Programlama", 10000);

        Category category = new Category(1, "Programming");
        Instructor instructor = new Instructor(1, "Engin Demiroğ");

        Logger[] loggers;
        loggers = new Logger[]{new DatabaseLogger(), new FileLogger(), new MailLogger()};

        List<Course> courses = new ArrayList<>();
        List<Category> categories = new ArrayList<>();
        List<Instructor> instructors = new ArrayList<>();

        CourseManager courseManager = new CourseManager(new JdbcCourseDao(), courses, loggers);
        courseManager.add(course);

        CategoryManager categoryManager = new CategoryManager(new HibernateCategoryDao(), loggers, categories);
        //categoryManager.addCategory(category);

        InstructorManager instructorManager = new InstructorManager(new HibernateInstructorDao(), instructors, loggers);
        instructorManager.add(instructor);
    }
}