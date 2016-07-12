package net.dontdrinkandroot.wicket.example.page.component;

import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropDownMenu;
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.DividerItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.HeaderItem;
import net.dontdrinkandroot.wicket.example.page.HomePage;


public class DropDownPage extends ComponentPage
{

	public DropDownPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		DropDownMenu dropDownMenu = new DropDownMenu("dropDownMenu") {

			@Override
			protected void populateItems(RepeatingView itemView)
			{
				DropDownPage.this.populateItems(itemView);
			}
		};
		this.add(dropDownMenu);
	}

	@Override
	protected IModel<String> createPageHeadingModel()
	{
		return Model.of("Dropdowns");
	}

	protected void populateItems(RepeatingView itemView)
	{
		itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Action"), HomePage.class));
		itemView.add(new DividerItem(itemView.newChildId()));
		itemView.add(new HeaderItem(itemView.newChildId(), Model.of("A Header")));
		itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Another Action"), HomePage.class));

	}
}
