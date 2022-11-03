package business;

import Core.Logging.Logger;
import dataAccess.Instructor.InstructorDao;
import entitites.Instructor;

import java.util.List;

public class InstructorManager {
    private InstructorDao instructorDao;
    private List<Instructor> instructors;
    private Logger[] loggers;

    public InstructorManager(InstructorDao instructorDao, List<Instructor> instructors, Logger[] loggers) {
        this.instructorDao = instructorDao;
        this.instructors = instructors;
        this.loggers = loggers;
    }

    public InstructorDao getInstructorDao() {
        return instructorDao;
    }

    public void setInstructorDao(InstructorDao instructorDao) {
        this.instructorDao = instructorDao;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public Logger[] getLoggers() {
        return loggers;
    }

    public void setLoggers(Logger[] loggers) {
        this.loggers = loggers;
    }

    public void add(Instructor instructor) throws Exception {
        for (Instructor instructor1 : instructors) {
            if (instructor.getName().equals(instructor.getName())) {
                throw new Exception("Eğitmen ismi tekrar edemez.");
            }

        }
        instructorDao.add(instructor);
        instructors.add(instructor);

        for (Logger logger : loggers) {
            logger.log(instructor.getName());

        }
    }
}
