package net.dontdrinkandroot.wicket.component.form;

import net.dontdrinkandroot.wicket.test.FormComponentTestPage;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class AjaxDropDownChoiceTest extends WicketTestCase
{
    @Test
    public void testAjaxBehavior()
    {
        IModel<String> model = new Model<>();
        IModel<Boolean> selectionChangedCalled = Model.of(Boolean.FALSE);
        AjaxDropDownChoice<String> dropDownChoice =
                new AjaxDropDownChoice<String>("id", model, Arrays.asList("Red", "Green", "Blue"))
                {
                    @Override
                    protected void onSelectionChanged(AjaxRequestTarget target)
                    {
                        super.onSelectionChanged(target);
                        selectionChangedCalled.setObject(Boolean.TRUE);
                    }
                };
        FormComponentTestPage formComponentTestPage = new FormComponentTestPage(dropDownChoice)
        {
            @Override
            public String getFormComponentMarkup()
            {
                return "<select wicket:id=\"id\"></select>";
            }
        };

        this.tester.startPage(formComponentTestPage);
        FormTester formTester = this.tester.newFormTester("form");
        formTester.select("id", 1);
        this.tester.executeAjaxEvent(dropDownChoice, "change");
        Assert.assertTrue(selectionChangedCalled.getObject());
        Assert.assertEquals("Green", model.getObject());
    }
}
