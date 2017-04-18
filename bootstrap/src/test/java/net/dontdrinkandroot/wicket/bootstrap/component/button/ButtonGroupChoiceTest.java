package net.dontdrinkandroot.wicket.bootstrap.component.button;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ButtonGroupChoiceTest extends AbstractWicketTest
{
    @Test
    public void testDefault()
    {
        List<String> choices = Arrays.asList("Alpha", "Beta", "Gamma");
        ButtonGroupChoice<String> component =
                new ButtonGroupChoice<String>("id", Model.of("Beta"), choices);
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);
        Assert.assertEquals("<wicket:container wicket:id=\"id\" id=\"id1\" class=\"btn-group\"><wicket:panel>\n" +
                "\t\t<a href=\"javascript:;\" wicket:id=\"choice\" class=\"btn btn btn-default\" id=\"id12\">Alpha</a><a href=\"javascript:;\" wicket:id=\"choice\" class=\"btn btn btn-default active\" id=\"id23\">Beta</a><a href=\"javascript:;\" wicket:id=\"choice\" class=\"btn btn btn-default\" id=\"id34\">Gamma</a>\n" +
                "\t</wicket:panel></wicket:container>", componentMarkup.toString());
    }
}
