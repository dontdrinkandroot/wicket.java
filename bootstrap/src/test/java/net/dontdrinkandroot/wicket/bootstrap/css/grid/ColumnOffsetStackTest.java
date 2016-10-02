package net.dontdrinkandroot.wicket.bootstrap.css.grid;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ColumnOffsetStackTest
{
    @Test
    public void testGetInverseColumnSize()
    {
        ColumnOffsetStack stack = new ColumnOffsetStack(
                ColumnOffsetExtraSmall.COLUMNS_2,
                ColumnOffsetSmall.COLUMNS_3,
                ColumnOffsetMedium.COLUMNS_4,
                ColumnOffsetLarge.COLUMNS_5
        );
        ColumnSize inverseStack = stack.getInverseColumnSize();
        Assert.assertEquals("col-xs-10 col-sm-9 col-md-8 col-lg-7", inverseStack.getClassString());
    }

    @Test
    public void getGetInverseColumnOffset()
    {
        ColumnOffsetStack stack = new ColumnOffsetStack(
                ColumnOffsetExtraSmall.COLUMNS_2,
                ColumnOffsetSmall.COLUMNS_3,
                ColumnOffsetMedium.COLUMNS_4,
                ColumnOffsetLarge.COLUMNS_5
        );
        ColumnOffset inverseStack = stack.getInverseColumnOffset();
        Assert.assertEquals(
                "col-xs-offset-10 col-xs-offset-9 col-xs-offset-8 col-xs-offset-7",
                inverseStack.getClassString()
        );
    }
}
