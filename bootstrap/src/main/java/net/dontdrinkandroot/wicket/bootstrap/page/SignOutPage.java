package net.dontdrinkandroot.wicket.bootstrap.page;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class SignOutPage extends BootstrapPage<Void>
{
    private IModel<String> pageTitleModel;

    public SignOutPage()
    {
        this(null);
    }

    public SignOutPage(PageParameters parameters)
    {
        super(parameters);
        this.getSession().invalidate();
    }

    @Override
    protected void onInitialize()
    {
        this.pageTitleModel = this.createPageTitleModel();

        super.onInitialize();

        this.add(new Label("message", this.createPageTitleModel()));
    }

    @Override
    protected Component createPageTitle(String id)
    {
        return new Label(id, this.pageTitleModel);
    }

    protected IModel<String> createPageTitleModel()
    {
        return new ResourceModel("logout.success", Model.of("You have been signed out successfully"));
    }
}
