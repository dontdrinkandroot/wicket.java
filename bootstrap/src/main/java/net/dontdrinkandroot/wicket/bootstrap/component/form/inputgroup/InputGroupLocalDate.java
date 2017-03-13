package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup;

import net.dontdrinkandroot.wicket.component.form.LocalDateTextField;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.HTML5Attributes;
import org.apache.wicket.model.IModel;

import java.time.LocalDate;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class InputGroupLocalDate extends InputGroup<LocalDate, LocalDate, LocalDateTextField>
{
    public InputGroupLocalDate(String id, IModel<LocalDate> model)
    {
        super(id, model);
    }

    @Override
    protected LocalDateTextField createFormComponent(String id)
    {
        LocalDateTextField formComponent = new LocalDateTextField(id, this.getModel())
        {
            @Override
            protected void onComponentTag(ComponentTag tag)
            {
                tag.put("type", "date");
                super.onComponentTag(tag);
            }
        };
        formComponent.add(new HTML5Attributes());

        return formComponent;
    }
}
