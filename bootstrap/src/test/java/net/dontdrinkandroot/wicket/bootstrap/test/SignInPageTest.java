package net.dontdrinkandroot.wicket.bootstrap.test;

import net.dontdrinkandroot.wicket.bootstrap.page.SignInPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class SignInPageTest extends AbstractWicketTest
{
    @Test
    public void testInstantiation()
    {
        this.tester.startPage(new SignInPage(new PageParameters())
        {
            @Override
            protected boolean isSignedIn()
            {
                return false;
            }

            @Override
            protected boolean signIn(String username, String password)
            {
                return false;
            }
        });
        this.tester.assertRenderedPage(SignInPage.class);
    }
}
