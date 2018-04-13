package net.dontdrinkandroot.wicket.bootstrap.behavior;

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior;
import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.WellSize;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class WellBehavior extends CompositeBehavior
{
    public WellBehavior()
    {
        super(new CssClassAppender(BootstrapCssClass.WELL));
    }

    public WellBehavior(WellSize size)
    {
        this(Model.of(size));
    }

    public WellBehavior(IModel<WellSize> sizeModel)
    {
        super(new CssClassAppender(BootstrapCssClass.WELL));
        this.addBehavior(new CssClassAppender(sizeModel));
    }
}
