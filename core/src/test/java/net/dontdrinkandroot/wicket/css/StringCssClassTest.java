package net.dontdrinkandroot.wicket.css;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class StringCssClassTest
{
    @Test
    public void testGetClassString()
    {
        CssClass cssClass = new StringCssClass("test");
        Assert.assertEquals("test", cssClass.getClassString());
    }
}
