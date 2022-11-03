package dataAccess.Instructor;

import entitites.Instructor;

public class JdbcInstructorDao implements InstructorDao{
    @Override
    public void add(Instructor instructor) {
        System.out.println("Jdbc ile veritabanına eklendi");
    }
}
