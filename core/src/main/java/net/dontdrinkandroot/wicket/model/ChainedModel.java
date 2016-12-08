package net.dontdrinkandroot.wicket.model;

import org.apache.wicket.model.IModel;

/**
 * An {@link IModel} that resolves its object based on another parent Model. It therefore does not have to hold any
 * data itsself but rather knows how to transform the data of the parent model.
 *
 * @param <P> Type of the parent Model.
 * @param <T> Type of the resolved model object.
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public interface ChainedModel<P, T> extends IModel<T>
{
    IModel<? extends P> getParent();

    P getParentObject();
}
