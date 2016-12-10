package net.dontdrinkandroot.wicket.model;

import org.apache.wicket.model.IModel;

/**
 * {@link ChainedModel} that simply returns the toString() result of the parent object.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ToStringModel extends AbstractChainedReadonlyModel<Object, String>
{
    public ToStringModel(IModel<?> parent)
    {
        super(parent);
    }

    @Override
    public String getObject()
    {
        return this.getParentObject().toString();
    }
}
