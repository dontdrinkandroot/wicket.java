package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import net.dontdrinkandroot.wicket.bootstrap.AbstractWicketTest;
import net.dontdrinkandroot.wicket.bootstrap.TestFormPanel;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormGroupLocalDateTimeTest extends AbstractWicketTest
{
    @Test
    public void testFullMarkup()
    {
        TestFormPanel formPanel = new TestFormPanel("id");

        FormGroupLocalDateTime formGroupLocalDate =
                new FormGroupLocalDateTime(
                        "formGroup",
                        Model.of("Label"),
                        Model.of(LocalDateTime.of(2017, 1, 2, 3, 4))
                );
        formGroupLocalDate.getFormComponent().setMin(LocalDateTime.of(2016, 6, 4, 23, 46));
        formGroupLocalDate.getFormComponent().setMax(LocalDateTime.of(2018, 9, 6, 12, 53));
        formPanel.getForm().add(formGroupLocalDate);

        CharSequence componentMarkup = ComponentRenderer.renderComponent(formGroupLocalDate);

        TagTester formComponentTester =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formComponent");
        Assert.assertEquals("form-control", formComponentTester.getAttribute("class"));
        Assert.assertEquals("datetime-local", formComponentTester.getAttribute("type"));
        Assert.assertEquals("2017-01-02T03:04", formComponentTester.getAttribute("value"));
        Assert.assertEquals("2016-06-04T23:46", formComponentTester.getAttribute("min"));
        Assert.assertEquals("2018-09-06T12:53", formComponentTester.getAttribute("max"));
        Assert.assertEquals("Label", formComponentTester.getAttribute("placeholder"));
    }
}
