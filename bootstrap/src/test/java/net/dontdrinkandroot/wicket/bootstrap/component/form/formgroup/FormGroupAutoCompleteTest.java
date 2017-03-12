package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import net.dontdrinkandroot.wicket.bootstrap.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormGroupAutoCompleteTest extends AbstractWicketTest
{
    @Test
    public void testMarkup()
    {
        FormGroupAutoComplete component = new FormGroupAutoComplete("id", Model.of("ExampleLabel"), new Model<>())
        {
            @Override
            protected List<String> getChoices(String input)
            {
                return Arrays.asList("Alpha", "Beta", "Gamma");
            }
        };
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);
        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" id=\"id1\" class=\"form-group dropdown autocomplete\"><wicket:panel>\n" +
                        "\t\t<label wicket:id=\"label\" class=\"control-label\" for=\"formComponent2\">ExampleLabel</label>\n" +
                        "\t\t\n" +
                        "\t\t\t<wicket:child><wicket:extend>\n" +
                        "\t\t<wicket:child><wicket:extend>\n" +
                        "\t\t<input type=\"text\" wicket:id=\"formComponent\" class=\"form-control dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" autocomplete=\"off\" value=\"\" name=\"id:container:formComponent\" id=\"formComponent2\"/>\n" +
                        "\t\t<ul class=\"dropdown-menu\" aria-labelledby=\"dropdownMenu\" wicket:id=\"dropDownMenu\" id=\"dropDownMenu3\">\n" +
                        "\t\t\t<li wicket:id=\"suggestionItem\">\n" +
                        "\t\t\t\t<a wicket:id=\"link\" id=\"link4\" href=\"javascript:;\">Alpha</a>\n" +
                        "\t\t\t</li><li wicket:id=\"suggestionItem\">\n" +
                        "\t\t\t\t<a wicket:id=\"link\" id=\"link5\" href=\"javascript:;\">Beta</a>\n" +
                        "\t\t\t</li><li wicket:id=\"suggestionItem\">\n" +
                        "\t\t\t\t<a wicket:id=\"link\" id=\"link6\" href=\"javascript:;\">Gamma</a>\n" +
                        "\t\t\t</li>\n" +
                        "\t\t</ul>\n" +
                        "\t</wicket:extend></wicket:child>\n" +
                        "\t\t<div id=\"helpBlock7\" style=\"display:none\"></div>\n" +
                        "\t</wicket:extend></wicket:child>\n" +
                        "\t\t\n" +
                        "\t</wicket:panel></wicket:container>",
                componentMarkup.toString()
        );
    }
}
