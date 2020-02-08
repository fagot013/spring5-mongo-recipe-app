package guru.springframework.repositories.reactive;

import guru.springframework.domain.Recipe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author AlexM
 * Date: 2/8/20
 **/
public interface RecipeReactiveRepository extends ReactiveMongoRepository<Recipe, String> {

}
