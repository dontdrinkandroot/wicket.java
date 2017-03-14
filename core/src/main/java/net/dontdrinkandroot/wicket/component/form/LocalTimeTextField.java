package net.dontdrinkandroot.wicket.component.form;

import net.dontdrinkandroot.wicket.converter.LocalTimeConverter;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.convert.IConverter;
import org.apache.wicket.util.value.IValueMap;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class LocalTimeTextField extends TextField<LocalTime>
{
    private IModel<LocalTime> minModel = new Model<>();

    private IModel<LocalTime> maxModel = new Model<>();

    public LocalTimeTextField(String id)
    {
        super(id, LocalTime.class);
    }

    public LocalTimeTextField(String id, IModel<LocalTime> model)
    {
        super(id, model, LocalTime.class);
    }

    @Override
    protected IConverter<?> createConverter(Class<?> type)
    {
        if (LocalDate.class.isAssignableFrom(type)) {
            return new LocalTimeConverter();
        }

        return null;
    }

    public LocalTimeTextField setMin(LocalTime min)
    {
        this.minModel.setObject(min);
        return this;
    }

    public LocalTimeTextField setMax(LocalTime max)
    {
        this.maxModel.setObject(max);
        return this;
    }

    public LocalTimeTextField setMinModel(IModel<LocalTime> minModel)
    {
        this.minModel = minModel;
        return this;
    }

    public LocalTimeTextField setMaxModel(IModel<LocalTime> maxModel)
    {
        this.maxModel = maxModel;
        return this;
    }

    @Override
    protected void onComponentTag(ComponentTag tag)
    {
        super.onComponentTag(tag);

        IConverter<LocalTime> converter = this.getConverter(LocalTime.class);
        IValueMap attributes = tag.getAttributes();
        final LocalTime min = this.minModel.getObject();
        if (min != null) {
            attributes.put("min", converter.convertToString(min, this.getLocale()));
        } else {
            attributes.remove("min");
        }

        final LocalTime max = this.maxModel.getObject();
        if (max != null) {
            attributes.put("max", converter.convertToString(max, this.getLocale()));
        } else {
            attributes.remove("max");
        }
    }

    @Override
    protected String[] getInputTypes()
    {
        return new String[]{"text", "time"};
    }
}
