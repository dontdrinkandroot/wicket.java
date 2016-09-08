package net.dontdrinkandroot.wicket.behavior.ajax;

import net.dontdrinkandroot.wicket.AbstractWicketTest;
import net.dontdrinkandroot.wicket.TestPage;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class KeyEventBehaviorTest extends AbstractWicketTest
{
    @Test
    public void testBla()
    {

        TestPage page = new TestPage()
        {
            @Override
            protected void onInitialize()
            {
                super.onInitialize();
                this.add(new KeyEventBehavior()
                {
                    @Override
                    protected void onEvent(AjaxRequestTarget target, KeyEventResponse keyPressResponse)
                    {
                        Assert.assertEquals(-1, keyPressResponse.getCharCode());
                        Assert.assertEquals(-1, keyPressResponse.getKeyCode());
                        Assert.assertEquals(-1, keyPressResponse.getWhich());
                        Assert.assertFalse(keyPressResponse.isAltKey());
                        Assert.assertFalse(keyPressResponse.isCtrlKey());
                        Assert.assertFalse(keyPressResponse.isMetaKey());
                        Assert.assertFalse(keyPressResponse.isShiftKey());
                    }
                });
            }
        };

        this.tester.startPage(page);
        this.tester.debugComponentTrees();
        this.tester.executeAjaxEvent(page, "keyup");
    }
}
