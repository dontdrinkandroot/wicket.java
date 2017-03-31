package net.dontdrinkandroot.wicket.bootstrap.component.item;

import org.apache.wicket.model.IModel;

/**
 * {@link AbstractItem} that contains a Text.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class AbstractLabeledItem<T> extends AbstractItem<T> implements LabeledItem
{
    private IModel<String> labelModel;

    public AbstractLabeledItem(String id, IModel<String> labelModel)
    {
        this(id, labelModel, null);
    }

    public AbstractLabeledItem(String id, IModel<String> labelModel, IModel<T> model)
    {
        super(id, model);
        this.labelModel = labelModel;
    }

    @Override
    public IModel<String> getLabel()
    {
        return this.labelModel;
    }
}
