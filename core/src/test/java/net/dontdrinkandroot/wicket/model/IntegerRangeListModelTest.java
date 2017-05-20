package net.dontdrinkandroot.wicket.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class IntegerRangeListModelTest
{
    @Test
    public void testRanges()
    {
        IntegerRangeListModel model = new IntegerRangeListModel(1, 3);
        Assert.assertTrue(Arrays.asList(1, 2, 3).equals(model.getObject()));
        model.setMin(2);
        Assert.assertTrue(Arrays.asList(2, 3).equals(model.getObject()));
        model.setMax(4);
        Assert.assertTrue(Arrays.asList(2, 3, 4).equals(model.getObject()));
        Assert.assertEquals(2, model.getMin());
        Assert.assertEquals(4, model.getMax());
    }
}
