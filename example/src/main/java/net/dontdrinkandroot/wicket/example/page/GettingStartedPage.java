package net.dontdrinkandroot.wicket.example.page;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class GettingStartedPage extends DecoratorPage<Void>
{
    @Override
    protected IModel<String> createPageHeadingModel()
    {
        return Model.of("Getting started");
    }
}
