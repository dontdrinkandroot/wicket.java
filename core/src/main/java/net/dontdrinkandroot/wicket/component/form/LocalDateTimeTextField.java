package net.dontdrinkandroot.wicket.component.form;

import net.dontdrinkandroot.wicket.converter.LocalDateTimeConverter;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.convert.IConverter;

import java.time.LocalDateTime;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class LocalDateTimeTextField extends AbstractTemporalAccessorTextField<LocalDateTime>
{
    public LocalDateTimeTextField(String id)
    {
        super(id, LocalDateTime.class);
    }

    public LocalDateTimeTextField(String id, IModel<LocalDateTime> model)
    {
        super(id, model, LocalDateTime.class);
    }

    @Override
    protected IConverter<?> createConverter(Class<?> type)
    {
        if (LocalDateTime.class.isAssignableFrom(type)) {
            return new LocalDateTimeConverter();
        }

        return null;
    }

    @Override
    protected String[] getInputTypes()
    {
        return new String[]{"text", "datetime-local"};
    }
}
