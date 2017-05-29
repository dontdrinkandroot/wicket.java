package net.dontdrinkandroot.wicket.bootstrap.component.nav;

import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class AbstractRepeatingNav<T> extends GenericPanel<T>
{
    public AbstractRepeatingNav(String id)
    {
        super(id);
    }

    public AbstractRepeatingNav(String id, IModel<T> model)
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

    protected void populateItems(RepeatingView itemView)
    {
        /* Hook */
    }
}
