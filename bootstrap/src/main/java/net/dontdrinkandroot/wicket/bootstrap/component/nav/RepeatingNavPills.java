package net.dontdrinkandroot.wicket.bootstrap.component.nav;

import net.dontdrinkandroot.wicket.bootstrap.behavior.NavPillsBehavior;
import org.apache.wicket.model.IModel;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class RepeatingNavPills<T> extends AbstractRepeatingNav<T>
{
    private NavPillsBehavior navPillsBehavior = new NavPillsBehavior();

    public RepeatingNavPills(String id)
    {
        this(id, null);
    }

    public RepeatingNavPills(String id, IModel<T> model)
    {
        super(id, model);
        this.add(this.navPillsBehavior);
    }

    public void setStacked(boolean stacked)
    {
        this.navPillsBehavior.setStacked(stacked);
    }

    public void setJustified(boolean justified)
    {
        this.navPillsBehavior.setJustified(justified);
    }
}
