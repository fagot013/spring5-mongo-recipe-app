package guru.springframework.repositories.reactive;

import guru.springframework.domain.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author AlexM
 * Date: 2/8/20
 **/
@RunWith(SpringRunner.class)
@DataMongoTest
public class CategoryReactiveRepositoryIT {

    @Autowired
    CategoryReactiveRepository categoryReactiveRepository;

    @Before
    public void cleanUp() {
        categoryReactiveRepository.deleteAll().block();
    }

    @Test
    public void testCategorySave() {
        Category category = new Category();
        category.setDescription("Best category");
        categoryReactiveRepository.save(category).block();
        assertEquals(1L, categoryReactiveRepository.count().block().longValue());
    }

    @Test
    public void testFindByDescription() {
        final String foo = "foo";
        Category category = new Category();
        category.setDescription(foo);
        categoryReactiveRepository.save(category).block();

        Category actualCategory = categoryReactiveRepository.findByDescription(foo).block();
        assertNotNull(actualCategory.getId());
    }
}