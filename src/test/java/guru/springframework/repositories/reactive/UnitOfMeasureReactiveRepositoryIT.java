package guru.springframework.repositories.reactive;

import guru.springframework.domain.UnitOfMeasure;
import org.junit.Before;
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
public class UnitOfMeasureReactiveRepositoryIT {

    @Autowired
    private UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository;
    private static final String INCH = "inch";

    @Before
    public void setUp() {
        unitOfMeasureReactiveRepository.deleteAll().block();
    }

    @Test
    public void testSave() {
        saveInchUoM();
        assertEquals(1L, unitOfMeasureReactiveRepository.count().block().longValue());
    }

    private void saveInchUoM() {
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setDescription(INCH);
        unitOfMeasureReactiveRepository.save(uom).block();
    }

    @Test
    public void testFindByDescription() {
        saveInchUoM();
        final UnitOfMeasure actual = unitOfMeasureReactiveRepository.findByDescription(INCH).block();
        assertNotNull(actual);
    }

}