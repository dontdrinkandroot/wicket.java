package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.inputgroup.addon;

import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText;
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.addon.InputGroupButton;
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.addon.InputGroupLabel;
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import net.dontdrinkandroot.wicket.bootstrap.test.TestFormPanel;
import net.dontdrinkandroot.wicket.bootstrap.test.TestHomePage;
import org.apache.wicket.Component;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class InputGroupAddonTest extends AbstractWicketTest
{
    @Test
    public void testMarkup()
    {
        TestFormPanel formPanel = new TestFormPanel("id");

        FormGroupInputText formGroupInputText =
                new FormGroupInputText("formGroup", Model.of("Label"), Model.of("Value"))
                {
                    @Override
                    protected Component createInputGroupAddonBefore(String id)
                    {
                        return new InputGroupLabel(id, Model.of("Label"));
                    }

                    @Override
                    protected Component createInputGroupAddonAfter(String id)
                    {
                        return new InputGroupButton(id)
                        {
                            @Override
                            protected Component createLink(String id)
                            {
                                return new BookmarkablePageLink(id, TestHomePage.class);
                            }
                        };
                    }
                };
        formPanel.getForm().add(formGroupInputText);

        CharSequence componentMarkup = ComponentRenderer.renderComponent(formGroupInputText);
        TagTester inputGroupAddonBefore =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "inputGroupAddonBefore");
        Assert.assertEquals("input-group-addon", inputGroupAddonBefore.getAttribute("class"));
        TagTester inputGroupAddonAfter =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "inputGroupAddonAfter");
        Assert.assertEquals("input-group-btn", inputGroupAddonAfter.getAttribute("class"));
    }
}
