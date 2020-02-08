package guru.springframework.repositories.reactive;

import guru.springframework.domain.Recipe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author AlexM
 * Date: 2/8/20
 **/
@RunWith(SpringRunner.class)
@DataMongoTest
public class RecipeReactiveRepositoryIT {

    @Autowired
    RecipeReactiveRepository recipeReactiveRepository;

    @Test
    public void testSave() {
        Recipe recipe = new Recipe();
        recipe.setCookTime(22);
        recipeReactiveRepository.save(recipe).block();

        assertEquals(1L, recipeReactiveRepository.count().block().longValue());
    }
}