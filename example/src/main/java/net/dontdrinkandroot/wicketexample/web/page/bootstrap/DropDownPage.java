package net.dontdrinkandroot.wicketexample.web.page.bootstrap;

import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropDownMenu;
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.DividerItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.HeaderItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.LabelItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.SubMenuItem;

import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class DropDownPage extends AbstractBootstrapPage<Void> {

	public DropDownPage(PageParameters parameters) {

		super(parameters);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		DropDownMenu allItemsMenu = new DropDownMenu("allItemsMenu") {

			@Override
			protected void createItems(RepeatingView itemView) {

				itemView.add(new HeaderItem(itemView.newChildId(), Model.of("Header")));
				itemView.add(new BookmarkablePageLinkItem(
						itemView.newChildId(),
						DropDownPage.class,
						Model.of("Link Item")));
				itemView.add(new DividerItem(itemView.newChildId()));
				itemView.add(new SubMenuItem(itemView.newChildId(), Model.of("SubMenu")) {

					@Override
					protected void createItems(RepeatingView itemView) {

						itemView.add(new LabelItem(itemView.newChildId(), Model.of("Label Item 1")));
						itemView.add(new LabelItem(itemView.newChildId(), Model.of("Label Item 2")));
					}
				});
			}
		};
		this.add(allItemsMenu);
	}


	@Override
	protected IModel<String> getPageTitleModel() {

		return new Model<String>("DropDown Demo");
	}

}
