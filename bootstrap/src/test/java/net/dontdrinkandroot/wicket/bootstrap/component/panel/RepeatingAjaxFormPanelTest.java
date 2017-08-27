package net.dontdrinkandroot.wicket.bootstrap.component.panel;

import net.dontdrinkandroot.wicket.bootstrap.component.button.SubmitLabelButton;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText;
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class RepeatingAjaxFormPanelTest extends AbstractWicketTest
{
    @Test
    public void testMarkup()
    {
        RepeatingAjaxFormPanel component = new RepeatingAjaxFormPanel("id", Model.of("title"))
        {
            @Override
            protected void populateFormGroups(RepeatingView formGroupView)
            {
                super.populateFormGroups(formGroupView);
                formGroupView.add(new FormGroupInputText(formGroupView.newChildId(), Model.of("Text"), new Model<>()));
            }

            @Override
            protected void populateActions(RepeatingView buttonView)
            {
                super.populateActions(buttonView);
                buttonView.add(new SubmitLabelButton(buttonView.newChildId(), Model.of("Submit")));
            }
        };

        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);
        TagTester formTester =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assert.assertTrue(formTester.getAttributeContains("class", "panel"));
        Assert.assertTrue(formTester.getAttributeContains("class", "panel-default"));
    }
}
