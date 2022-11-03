package business;

import Core.Logging.Logger;
import dataAccess.Course.CourseDao;
import entitites.Course;

import java.util.List;

public class CourseManager {
    private CourseDao courseDao;
    private List<Course> courses;
    private Logger[] loggers;

    public CourseManager(CourseDao courseDao, List<Course> courses, Logger[] loggers) {
        this.courseDao = courseDao;
        this.courses = courses;
        this.loggers = loggers;
    }

    public void add(Course course) throws Exception {
        if (course.getPrice() < 0) {
            throw new Exception("Kurs fiyati 0 dan küçük olamaz");
        }
        for (Course course1 : courses) {
            if (course.getName().equals(course1.getName())) {
                throw new Exception("Kurs ismi tekrar edemez");
            }
        }
        courseDao.add(course);
        courses.add(course);

        for (Logger logger : loggers) {
            logger.log(course.getName());
        }
    }
}
