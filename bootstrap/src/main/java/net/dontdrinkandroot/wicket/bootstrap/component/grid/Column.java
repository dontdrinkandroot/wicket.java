package net.dontdrinkandroot.wicket.bootstrap.component.grid;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSize;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeSmall;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class Column<T> extends GenericPanel<T>
{
    private IModel<ColumnSize> sizeModel;

    public Column(String id, IModel<ColumnSize> sizeModel)
    {
        super(id);
        this.sizeModel = sizeModel;
    }

    public Column(String id, IModel<ColumnSize> sizeModel, IModel<T> model)
    {
        super(id, model);
        this.sizeModel = sizeModel;
    }

    public Column(String id, ColumnSizeSmall size, IModel<T> model)
    {
        this(id, Model.of(size), model);
    }

    public Column(String id, ColumnSizeSmall size)
    {
        this(id, Model.of(size));
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new CssClassAppender(this.sizeModel));
        this.add(this.createContent("content"));
    }

    protected abstract Component createContent(String id);
}
