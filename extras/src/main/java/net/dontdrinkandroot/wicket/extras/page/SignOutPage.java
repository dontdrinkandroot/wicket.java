package net.dontdrinkandroot.wicket.extras.page;

import net.dontdrinkandroot.wicket.bootstrap.page.BootstrapPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class SignOutPage extends BootstrapPage<Void>
{
    public SignOutPage()
    {
    }

    public SignOutPage(PageParameters parameters)
    {
        super(parameters);
    }

    @Override
    protected IModel<String> createPageHeadingModel()
    {
        return Model.of("Signed Out");
    }
}
