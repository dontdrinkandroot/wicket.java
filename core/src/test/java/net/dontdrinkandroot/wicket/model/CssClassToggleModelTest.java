package net.dontdrinkandroot.wicket.model;

import net.dontdrinkandroot.wicket.css.StringCssClass;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class CssClassToggleModelTest
{
    @Test
    public void testByModelActive()
    {
        IModel<Boolean> activeModel = Model.of(Boolean.FALSE);

        StringCssClass activeClass = new StringCssClass("active");

        CssClassToggleModel model = new CssClassToggleModel(activeModel, activeClass);
        Assert.assertNull(model.getObject());

        activeModel.setObject(Boolean.TRUE);
        Assert.assertEquals(activeClass, model.getObject());
    }

    @Test
    public void testByModelActiveInactive()
    {
        IModel<Boolean> activeModel = Model.of(Boolean.FALSE);

        StringCssClass activeClass = new StringCssClass("active");
        StringCssClass inactiveClass = new StringCssClass("inactive");

        CssClassToggleModel model = new CssClassToggleModel(activeModel, activeClass, inactiveClass);
        Assert.assertEquals(inactiveClass, model.getObject());

        activeModel.setObject(Boolean.TRUE);
        Assert.assertEquals(activeClass, model.getObject());
    }

    @Test
    public void testActiveInactiveAnonymous()
    {
        IModel<Boolean> activeModel = Model.of(Boolean.FALSE);

        StringCssClass activeClass = new StringCssClass("active");
        StringCssClass inactiveClass = new StringCssClass("inactive");

        CssClassToggleModel model = new CssClassToggleModel(activeClass)
        {
            @Override
            protected boolean isActive()
            {
                return activeModel.getObject();
            }
        };
        Assert.assertNull(model.getObject());

        activeModel.setObject(Boolean.TRUE);
        Assert.assertEquals(activeClass, model.getObject());
    }

    @Test
    public void testWithoutModel()
    {
        StringCssClass activeClass = new StringCssClass("active");
        CssClassToggleModel model = new CssClassToggleModel(activeClass);
        Assert.assertEquals(activeClass, model.getObject());
    }
}
