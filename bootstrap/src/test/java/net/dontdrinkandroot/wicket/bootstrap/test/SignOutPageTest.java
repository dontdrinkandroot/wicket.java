package net.dontdrinkandroot.wicket.bootstrap.test;

import net.dontdrinkandroot.wicket.bootstrap.page.SignOutPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class SignOutPageTest extends AbstractWicketTest
{
    @Test
    public void testInstantiation()
    {
        this.tester.startPage(new SignOutPage(new PageParameters()));
        this.tester.assertRenderedPage(SignOutPage.class);
    }
}
