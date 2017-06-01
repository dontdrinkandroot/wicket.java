package net.dontdrinkandroot.wicket.bootstrap.component.grid;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnOffset;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSize;
import net.dontdrinkandroot.wicket.css.CssClass;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class Column<T> extends GenericPanel<T>
{
    private IModel<ColumnSize> sizeModel = new Model<>();

    private IModel<ColumnOffset> offsetModel = new Model<>();

    public Column(String id)
    {
        super(id);
    }

    public Column(String id, IModel<T> model)
    {
        super(id, model);
    }

    public Column<T> setSizeModel(IModel<ColumnSize> sizeModel)
    {
        this.sizeModel = sizeModel;
        return this;
    }

    public Column<T> setSize(ColumnSize size)
    {
        this.sizeModel.setObject(size);
        return this;
    }

    public Column<T> setOffsetModel(IModel<ColumnOffset> offsetModel)
    {
        this.offsetModel = offsetModel;
        return this;
    }

    public Column<T> setOffset(ColumnOffset offset)
    {
        this.offsetModel.setObject(offset);
        return this;
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new CssClassAppender(new AbstractReadOnlyModel<CssClass>()
        {
            @Override
            public CssClass getObject()
            {
                return Column.this.sizeModel.getObject();
            }
        }));
        this.add(new CssClassAppender(new AbstractReadOnlyModel<CssClass>()
        {
            @Override
            public CssClass getObject()
            {
                return Column.this.offsetModel.getObject();
            }
        }));
        this.add(this.createContent("content"));
    }

    @Override
    public void detachModels()
    {
        super.detachModels();
        this.sizeModel.detach();
        this.offsetModel.detach();
    }

    protected abstract Component createContent(String id);
}
