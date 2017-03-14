package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup;

import net.dontdrinkandroot.wicket.component.form.LocalTimeTextField;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.HTML5Attributes;
import org.apache.wicket.model.IModel;

import java.time.LocalTime;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class InputGroupLocalTime extends InputGroup<LocalTime, LocalTime, LocalTimeTextField>
{
    public InputGroupLocalTime(String id, IModel<LocalTime> model)
    {
        super(id, model);
    }

    @Override
    protected LocalTimeTextField createFormComponent(String id)
    {
        LocalTimeTextField formComponent = new LocalTimeTextField(id, this.getModel())
        {
            @Override
            protected void onComponentTag(ComponentTag tag)
            {
                tag.put("type", "time");
                super.onComponentTag(tag);
            }
        };
        formComponent.add(new HTML5Attributes());

        return formComponent;
    }
}
