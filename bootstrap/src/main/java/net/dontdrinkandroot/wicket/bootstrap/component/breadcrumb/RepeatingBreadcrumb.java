package net.dontdrinkandroot.wicket.bootstrap.component.breadcrumb;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.component.basic.RepeatingList;
import org.apache.wicket.model.IModel;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class RepeatingBreadcrumb extends RepeatingList
{
    public RepeatingBreadcrumb(String id)
    {
        super(id);
    }

    public RepeatingBreadcrumb(String id, IModel model)
    {
        super(id, model);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();
        this.add(new CssClassAppender(BootstrapCssClass.BREADCRUMB));
    }
}
