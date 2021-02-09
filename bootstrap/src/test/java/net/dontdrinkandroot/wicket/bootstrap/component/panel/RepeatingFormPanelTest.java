package net.dontdrinkandroot.wicket.bootstrap.component.panel;

import net.dontdrinkandroot.wicket.bootstrap.component.button.SubmitLabelButton;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText;
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepeatingFormPanelTest extends AbstractWicketTest
{
    @Test
    public void testMarkup()
    {
        RepeatingFormPanel<Void> component = new RepeatingFormPanel<>("id", new Model<>("title"), null)
        {
            @Override
            protected void populateFormGroups(RepeatingView formGroupView) {
                super.populateFormGroups(formGroupView);
                formGroupView.add(new FormGroupInputText(
                        formGroupView.newChildId(),
                        new Model<>("Text"),
                        new Model<>()
                ));
            }

            @Override
            protected void populateActions(RepeatingView buttonView) {
                super.populateActions(buttonView);
                buttonView.add(new SubmitLabelButton(buttonView.newChildId(), Model.of("Submit")));
            }
        };

        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);
        TagTester formTester =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assertions.assertTrue(formTester.getAttributeContains("class", "panel"));
        Assertions.assertTrue(formTester.getAttributeContains("class", "panel-default"));
    }
}
