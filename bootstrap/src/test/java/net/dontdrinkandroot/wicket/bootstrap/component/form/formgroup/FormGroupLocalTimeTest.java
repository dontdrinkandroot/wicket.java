package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import net.dontdrinkandroot.wicket.bootstrap.test.TestFormPanel;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormGroupLocalTimeTest extends AbstractWicketTest
{
    @Test
    public void testFullMarkup()
    {
        TestFormPanel formPanel = new TestFormPanel("id");

        FormGroupLocalTime formGroupLocalTime =
                new FormGroupLocalTime("formGroup", Model.of("Label"), Model.of(LocalTime.of(13, 37)));
        formGroupLocalTime.getFormComponent().setMinModel(Model.of(LocalTime.of(9, 13, 14)));
        formGroupLocalTime.getFormComponent().setMax(LocalTime.of(17, 12));
        formPanel.getForm().add(formGroupLocalTime);

        CharSequence componentMarkup = ComponentRenderer.renderComponent(formGroupLocalTime);

        TagTester formComponentTester =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formComponent");
        Assert.assertTrue(formComponentTester.getAttributeContains("class", "form-control"));
        Assert.assertTrue(formComponentTester.getAttributeContains("type", "time"));
        Assert.assertTrue(formComponentTester.getAttributeContains("value", "13:37"));
        Assert.assertTrue(formComponentTester.getAttributeContains("min", "09:13"));
        Assert.assertTrue(formComponentTester.getAttributeContains("max", "17:12"));
        Assert.assertTrue(formComponentTester.getAttributeContains("placeholder", "Label"));
    }
}
