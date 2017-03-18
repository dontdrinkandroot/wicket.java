package net.dontdrinkandroot.wicket.component.form;

import net.dontdrinkandroot.wicket.converter.LocalTimeConverter;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.convert.IConverter;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class LocalTimeTextField extends AbstractTemporalAccessorTextField<LocalTime>
{
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

    @Override
    protected String[] getInputTypes()
    {
        return new String[]{"text", "time"};
    }
}
