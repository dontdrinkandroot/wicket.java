package net.dontdrinkandroot.wicket.page;

import net.dontdrinkandroot.wicket.test.AbstractWicketTest;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class Html5ScaffoldPageTest extends AbstractWicketTest
{
    @Test
    public void testInstantiation()
    {
        this.tester.startPage(Html5ScaffoldPage.class);
        System.out.println(this.tester.getLastResponseAsString());
        this.tester.assertRenderedPage(Html5ScaffoldPage.class);
    }
}
