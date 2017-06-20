package net.dontdrinkandroot.wicket.component.basic;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class RepeatingList<T> extends GenericPanel<T>
{
    public RepeatingList(String id)
    {
        super(id);
    }

    public RepeatingList(String id, IModel<T> model)
    {
        super(id, model);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        RepeatingView itemView = new RepeatingView("item");
        this.populateItems(itemView);
        this.add(itemView);
    }

    @Override
    protected void onComponentTag(ComponentTag tag)
    {
        super.onComponentTag(tag);
        if (!"ul".equals(tag.getName()) && !"ol".equals(tag.getName())) {
            this.findMarkupStream().throwMarkupException("Must be applied to ul or ol tag");
        }
    }

    protected abstract void populateItems(RepeatingView itemView);
}
