package net.dontdrinkandroot.wicket.bootstrap.behavior;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.util.tester.TagTester;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ButtonBehaviorTest extends AbstractWicketTest
{
    @Test
    public void testDefaultMarkup()
    {
        WebMarkupContainer buttonContainer = new WebMarkupContainer("id");
        buttonContainer.add(new ButtonBehavior());
        CharSequence componentMarkup = ComponentRenderer.renderComponent(buttonContainer);

        TagTester tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assertions.assertTrue(tagTester.getAttributeContains("class", "btn"));
        Assertions.assertTrue(tagTester.getAttributeContains("class", "btn-secondary"));
        Assertions.assertFalse(tagTester.getAttributeContains("class", "disabled"));
    }

    @Test
    public void testDisabledMarkup()
    {
        WebMarkupContainer buttonContainer = new WebMarkupContainer("id");
        buttonContainer.setEnabled(false);
        buttonContainer.add(new ButtonBehavior());
        CharSequence componentMarkup = ComponentRenderer.renderComponent(buttonContainer);

        TagTester tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assertions.assertTrue(tagTester.getAttributeContains("class", "btn"));
        Assertions.assertTrue(tagTester.getAttributeContains("class", "btn-secondary"));
        Assertions.assertTrue(tagTester.getAttributeContains("class", "disabled"));
    }
}
