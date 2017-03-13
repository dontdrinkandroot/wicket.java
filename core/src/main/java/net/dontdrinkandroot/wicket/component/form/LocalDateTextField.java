package net.dontdrinkandroot.wicket.component.form;

import net.dontdrinkandroot.wicket.converter.LocalDateConverter;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.convert.IConverter;
import org.apache.wicket.util.value.IValueMap;

import java.time.LocalDate;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class LocalDateTextField extends TextField<LocalDate>
{
    private IModel<LocalDate> minModel = new Model<>();

    private IModel<LocalDate> maxModel = new Model<>();

    public LocalDateTextField(String id)
    {
        super(id, LocalDate.class);
    }

    public LocalDateTextField(String id, IModel<LocalDate> model)
    {
        super(id, model, LocalDate.class);
    }

    @Override
    protected IConverter<?> createConverter(Class<?> type)
    {
        if (LocalDate.class.isAssignableFrom(type)) {
            return new LocalDateConverter();
        }

        return null;
    }

    public LocalDateTextField setMin(LocalDate min)
    {
        this.minModel.setObject(min);
        return this;
    }

    public LocalDateTextField setMax(LocalDate max)
    {
        this.maxModel.setObject(max);
        return this;
    }

    public LocalDateTextField setMinModel(IModel<LocalDate> minModel)
    {
        this.minModel = minModel;
        return this;
    }

    public LocalDateTextField setMaxModel(IModel<LocalDate> maxModel)
    {
        this.maxModel = maxModel;
        return this;
    }

    @Override
    protected void onComponentTag(ComponentTag tag)
    {
        super.onComponentTag(tag);

        IValueMap attributes = tag.getAttributes();
        final LocalDate min = this.minModel.getObject();
        if (min != null) {
            attributes.put("min", min.toString());
        } else {
            attributes.remove("min");
        }

        final LocalDate max = this.maxModel.getObject();
        if (max != null) {
            attributes.put("max", max.toString());
        } else {
            attributes.remove("max");
        }
    }

    @Override
    protected String[] getInputTypes()
    {
        return new String[]{"text", "date"};
    }
}
