package net.dontdrinkandroot.wicket.component.form;

import net.dontdrinkandroot.wicket.converter.LocalDateConverter;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.convert.IConverter;

import java.time.LocalDate;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class LocalDateTextField extends AbstractTemporalAccessorTextField<LocalDate>
{
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

    @Override
    protected String[] getInputTypes()
    {
        return new String[]{"text", "date"};
    }
}
