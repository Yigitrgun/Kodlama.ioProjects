package dataAccess.Category;

import entitites.Category;

public class JdbcCategoryDao implements CategoryDao {

    @Override
    public void add(Category category) {
        System.out.println("Jdbc ile veritabanına eklendi.");
    }
}
