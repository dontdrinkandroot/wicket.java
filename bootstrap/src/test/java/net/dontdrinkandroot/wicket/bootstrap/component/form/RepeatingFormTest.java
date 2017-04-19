package net.dontdrinkandroot.wicket.bootstrap.component.form;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class RepeatingFormTest extends AbstractWicketTest
{
    @Test
    public void testPlainMarkup()
    {
        RepeatingForm component = new RepeatingForm("id");
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);

        Assert.assertEquals(
                "<wicket:form wicket:id=\"id\" id=\"id1\" method=\"post\" action=\"./wicket/page?0-0.IFormSubmitListener-id\"><wicket:panel>\n" +
                        "\t\t<div wicket:id=\"feedback\" id=\"feedback2\"><wicket:panel>\n" +
                        "\t\t\n" +
                        "\t</wicket:panel></div>\n" +
                        "\t\t\n" +
                        "\t\t<div wicket:id=\"actions\" id=\"actions3\" class=\"form-group\"><wicket:panel>\n" +
                        "\t\t<label wicket:id=\"label\" class=\"control-label\"></label>\n" +
                        "\t\t<div wicket:id=\"container\">\n" +
                        "\t\t\t<wicket:child><wicket:extend>\n" +
                        "    <div class=\"btn-toolbar\">\n" +
                        "        \n" +
                        "    </div>\n" +
                        "</wicket:extend></wicket:child>\n" +
                        "\t\t</div>\n" +
                        "\t</wicket:panel></div>\n" +
                        "\t</wicket:panel></wicket:form>",
                componentMarkup.toString()
        );
    }
}
