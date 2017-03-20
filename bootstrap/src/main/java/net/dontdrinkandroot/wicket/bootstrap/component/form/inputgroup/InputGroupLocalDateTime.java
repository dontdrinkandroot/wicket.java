package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup;

import net.dontdrinkandroot.wicket.component.form.LocalDateTimeTextField;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.HTML5Attributes;
import org.apache.wicket.model.IModel;

import java.time.LocalDateTime;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class InputGroupLocalDateTime extends InputGroup<LocalDateTime, LocalDateTime, LocalDateTimeTextField>
{
    public InputGroupLocalDateTime(String id, IModel<LocalDateTime> model)
    {
        super(id, model);
    }

    @Override
    protected LocalDateTimeTextField createFormComponent(String id)
    {
        LocalDateTimeTextField formComponent = new LocalDateTimeTextField(id, this.getModel())
        {
            @Override
            protected void onComponentTag(ComponentTag tag)
            {
                tag.put("type", "datetime-local");
                super.onComponentTag(tag);
            }
        };
        formComponent.add(new HTML5Attributes());

        return formComponent;
    }
}
