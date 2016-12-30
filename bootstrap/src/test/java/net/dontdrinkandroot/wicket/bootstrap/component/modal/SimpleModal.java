package net.dontdrinkandroot.wicket.bootstrap.component.modal;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class SimpleModal extends Modal<Void>
{
    public SimpleModal(String id)
    {
        super(id);
    }

    @Override
    protected IModel<String> createHeadingModel()
    {
        return Model.of("Modal Heading");
    }
}
