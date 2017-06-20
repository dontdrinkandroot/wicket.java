package net.dontdrinkandroot.wicket.example.page.component;

import net.dontdrinkandroot.wicket.bootstrap.component.breadcrumb.RepeatingBreadcrumb;
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;
import net.dontdrinkandroot.wicket.example.ExampleApplication;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class BreadcrumbPage extends ComponentPage
{
    public BreadcrumbPage(PageParameters parameters)
    {
        super(parameters);
    }

    @Override
    protected IModel<String> createPageHeadingModel()
    {
        return Model.of("Breadcrumbs");
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        RepeatingBreadcrumb breadcrumb = new RepeatingBreadcrumb("breadcrumb")
        {
            @Override
            protected void populateItems(RepeatingView itemView)
            {
                itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Examples"),
                        ExampleApplication.get().getHomePage()
                ));
                itemView.add(new BookmarkablePageLinkItem(
                        itemView.newChildId(),
                        Model.of("Breadcrumbs"),
                        BreadcrumbPage.class
                ));
            }
        };
        this.add(breadcrumb);
    }
}
