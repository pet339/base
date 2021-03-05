package hu.bme.mit.train.tachograph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TachographTest {
    TrainTachographImpl t;

    @Before
    public void before() {
        t = new TrainTachographImpl("1", "1", 1);
    }

    @Test
    public void CollectionHasSomeElements() {
        Assert.assertEquals(false, t.tachographTable.isEmpty());
    }
}
