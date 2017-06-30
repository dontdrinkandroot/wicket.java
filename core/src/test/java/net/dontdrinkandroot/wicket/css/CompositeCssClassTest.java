package net.dontdrinkandroot.wicket.css;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class CompositeCssClassTest
{
    @Test
    public void testOneElement()
    {
        CssClass cssClass;

        cssClass = new CompositeCssClass(new StringCssClass("asdf"));
        Assert.assertEquals("asdf", cssClass.getClassString());

        cssClass = new CompositeCssClass("asdf");
        Assert.assertEquals("asdf", cssClass.getClassString());
    }

    @Test
    public void testMultipleElements()
    {
        CssClass cssClass;

        cssClass = new CompositeCssClass(new StringCssClass("asdf"), new StringCssClass("qwer"));
        Assert.assertEquals("asdf qwer", cssClass.getClassString());

        cssClass = new CompositeCssClass("asdf", "qwer");
        Assert.assertEquals("asdf qwer", cssClass.getClassString());
    }
}
