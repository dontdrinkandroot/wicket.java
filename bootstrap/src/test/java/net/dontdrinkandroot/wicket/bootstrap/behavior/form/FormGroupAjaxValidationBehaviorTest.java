package net.dontdrinkandroot.wicket.bootstrap.behavior.form;

import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputEmail;
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import net.dontdrinkandroot.wicket.bootstrap.test.FormGroupTestPage;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormGroupAjaxValidationBehaviorTest extends AbstractWicketTest
{
    @Test
    public void testError()
    {
        FormGroupTestPage<FormGroupInputEmail> page = new FormGroupTestPage<FormGroupInputEmail>()
        {
            @Override
            protected FormGroupInputEmail createFormGroup(String id)
            {
                FormGroupInputEmail formGroup = new FormGroupInputEmail(id, Model.of("Label"), new Model<>());
                formGroup.addAjaxValidation("blur");

                return formGroup;
            }
        };
        this.tester.startPage(page);

        FormTester formTester = this.tester.newFormTester("form", false);
        formTester.setValue("formGroup:container:inputGroup:formComponent", "invalid");

        this.tester.executeAjaxEvent(page.getFormGroup().getFormComponent(), "blur");

        CharSequence componentMarkup = ComponentRenderer.renderComponent(page.getFormGroup());

        TagTester formGroupTester =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formGroup");
        Assert.assertTrue(formGroupTester.getAttributeContains("class", "form-group"));
        Assert.assertTrue(formGroupTester.getAttributeContains("class", "has-error"));

        //TODO: Test jQuery validations
        //TODO: Test feedback messages
    }
}
