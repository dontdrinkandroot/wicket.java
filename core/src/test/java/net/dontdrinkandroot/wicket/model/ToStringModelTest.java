package net.dontdrinkandroot.wicket.model;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ToStringModelTest
{
    @Test
    public void testIsReadOnly()
    {
        IModel<LocalDate> parentModel = Model.of(LocalDate.of(2012, 1, 2));
        IModel<String> model = new ToStringModel(parentModel);

        try {
            model.setObject("Test");
            Assert.fail("Runtimeexception expected");
        } catch (UnsupportedOperationException e) {
            Assert.assertEquals(
                    "Model class net.dontdrinkandroot.wicket.model.ToStringModel does not support setObject(Object)",
                    e.getMessage()
            );
        }
    }
}
