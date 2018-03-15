package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.css.CssClass;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public interface ItemContainer
{
    default CssClass getItemClass()
    {
        return null;
    }

    default CssClass getLinkClass()
    {
        return null;
    }
}
