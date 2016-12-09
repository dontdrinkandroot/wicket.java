package net.dontdrinkandroot.wicket.model;

import org.apache.wicket.model.IModel;

/**
 * A {@link ChainedModel} that is readonly.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
abstract public class AbstractChainedReadonlyModel<P, T> extends AbstractChainedModel<P, T>
{
    public AbstractChainedReadonlyModel(IModel<? extends P> parent)
    {
        super(parent);
    }

    @Override
    public final void setObject(T object)
    {
        throw new UnsupportedOperationException(String.format(
                "Model %s does not support setObject(Object)",
                this.getClass()
        ));
    }
}
