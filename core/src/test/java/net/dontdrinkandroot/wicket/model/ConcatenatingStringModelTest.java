package net.dontdrinkandroot.wicket.model;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ConcatenatingStringModelTest
{
    @Test
    public void testConstruction()
    {
        ConcatenatingStringModel concatenatingStringModel;

        concatenatingStringModel = new ConcatenatingStringModel(new Model<>(), (String) null);
        Assert.assertEquals("", concatenatingStringModel.getObject());

        concatenatingStringModel = new ConcatenatingStringModel(new Model<>("Parent"), (String) null);
        Assert.assertEquals("Parent", concatenatingStringModel.getObject());

        concatenatingStringModel = new ConcatenatingStringModel(new Model<>("Parent"), (IModel<String>) null);
        Assert.assertEquals("Parent", concatenatingStringModel.getObject());

        concatenatingStringModel = new ConcatenatingStringModel(new Model<>("Parent"), "Child");
        Assert.assertEquals("ParentChild", concatenatingStringModel.getObject());

        concatenatingStringModel = new ConcatenatingStringModel(new Model<>("Parent"), Model.of("Child"));
        Assert.assertEquals("ParentChild", concatenatingStringModel.getObject());

        concatenatingStringModel = new ConcatenatingStringModel(new Model<>("Parent"), "Child");
        Assert.assertEquals("ParentChild", concatenatingStringModel.getObject());

        concatenatingStringModel = new ConcatenatingStringModel(new Model<>("Parent"), Model.of("Child"));
        Assert.assertEquals("ParentChild", concatenatingStringModel.getObject());

        concatenatingStringModel = new ConcatenatingStringModel(new Model<>("Parent"), "-", Model.of("Child"));
        Assert.assertEquals("Parent-Child", concatenatingStringModel.getObject());
    }

    @Test
    public void testDetach()
    {
        LoadableDetachableModel<String> parentModel = new LoadableDetachableModel<String>()
        {
            @Override
            protected String load()
            {
                return "Parent";
            }
        };
        LoadableDetachableModel<String> childModel = new LoadableDetachableModel<String>()
        {
            @Override
            protected String load()
            {
                return "Child";
            }
        };
        ConcatenatingStringModel concatenatingStringModel = new ConcatenatingStringModel(parentModel, childModel);
        Assert.assertEquals("ParentChild", concatenatingStringModel.getObject());
        concatenatingStringModel.detach();
        Assert.assertFalse(parentModel.isAttached());
        Assert.assertFalse(childModel.isAttached());
    }
}
