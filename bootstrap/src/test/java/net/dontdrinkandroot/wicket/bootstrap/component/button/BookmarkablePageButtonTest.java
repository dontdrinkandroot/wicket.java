package net.dontdrinkandroot.wicket.bootstrap.component.button;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import net.dontdrinkandroot.wicket.bootstrap.test.TestApplication;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.model.Model;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class BookmarkablePageButtonTest extends AbstractWicketTest
{
    @Test
    public void testIButton()
    {
        BookmarkablePageButton component = new BookmarkablePageButton("id", TestApplication.get().getHomePage());
        component.setBody(Model.of("Label"));
        this.testIButton(component);
    }

    @Test
    public void testMarkup()
    {
        BookmarkablePageButton component = new BookmarkablePageButton("id", TestApplication.get().getHomePage())
        {
            @Override
            protected void onComponentTag(ComponentTag tag)
            {
                tag.setName("a");
                super.onComponentTag(tag);
            }
        };
        component.setBody(Model.of("Label"));

        String componentMarkup = ComponentRenderer.renderComponent(component).toString();
        Assert.assertEquals(
                "<wicket:a wicket:id=\"id\" href=\"./\" class=\"btn btn-default\">Label</wicket:a>",
                componentMarkup
        );
    }
}
