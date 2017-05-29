package net.dontdrinkandroot.wicket.bootstrap.component.nav;

import net.dontdrinkandroot.wicket.bootstrap.behavior.NavTabsBehavior;
import org.apache.wicket.model.IModel;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class RepeatingNavTabs<T> extends AbstractRepeatingNav<T>
{
    private NavTabsBehavior navTabsBehavior = new NavTabsBehavior();

    public RepeatingNavTabs(String id)
    {
        this(id, null);
    }

    public RepeatingNavTabs(String id, IModel<T> model)
    {
        super(id, model);
        this.add(this.navTabsBehavior);
    }

    public void setJustified(boolean justified)
    {
        this.navTabsBehavior.setJustified(justified);
    }
}
