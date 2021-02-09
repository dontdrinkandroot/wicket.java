package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.behavior.DropdownToggleBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropdownMenu;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.model.IModel;

public abstract class DropdownItem<T> extends AbstractLinkItem<T, AbstractLink>
{
    protected DropdownMenu dropdownMenu;

    public DropdownItem(String id, IModel<String> labelModel) {
        this(id, labelModel, null);
    }

    public DropdownItem(String id, IModel<String> labelModel, IModel<T> model) {
        super(id, model, labelModel);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        this.add(new CssClassAppender(BootstrapCssClass.DROPDOWN));

        this.dropdownMenu = this.createDropdownMenu("dropdownMenu");
        this.add(this.dropdownMenu);
    }

    @Override
    protected AbstractLink createLink(String id) {
        AbstractLink link = new AbstractLink(id) {};
        link.add(new DropdownToggleBehavior());
        return link;
    }

    protected abstract DropdownMenu createDropdownMenu(String id);
}
