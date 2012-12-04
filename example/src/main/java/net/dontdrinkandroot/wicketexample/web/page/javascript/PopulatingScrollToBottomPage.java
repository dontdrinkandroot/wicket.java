package net.dontdrinkandroot.wicketexample.web.page.javascript;

import net.dontdrinkandroot.wicket.behavior.ajax.ScrollToBottomBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxButtonLink;
import net.dontdrinkandroot.wicket.component.repeater.AppendingDataView;
import net.dontdrinkandroot.wicketexample.entity.TestEntity;
import net.dontdrinkandroot.wicketexample.web.component.GenerateTestDataButton;
import net.dontdrinkandroot.wicketexample.web.dataprovider.TestEntitySortableDataProvider;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class PopulatingScrollToBottomPage extends AbstractJavascriptPage<Void> {

	public PopulatingScrollToBottomPage(final PageParameters parameters) {

		super(parameters);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new GenerateTestDataButton("generateTestDataLink"));

		final WebMarkupContainer itemViewContainer = new WebMarkupContainer("container");
		itemViewContainer.setOutputMarkupId(true);
		this.add(itemViewContainer);

		final AppendingDataView<TestEntity> itemView =
				new AppendingDataView<TestEntity>("item", new TestEntitySortableDataProvider(), "li", 50) {

					@Override
					protected void populateItem(Item<TestEntity> item) {

						item.add(new Label("id", item.getModelObject().getId().toString()));
					}

				};
		// itemView.setItemReuseStrategy(new ReuseIfModelsEqualStrategy());
		itemViewContainer.add(itemView);

		AjaxButtonLink<Void> showMoreLink = new AjaxButtonLink<Void>("showMoreLink") {

			@Override
			public void onClick(AjaxRequestTarget target) {

				itemView.setCurrentPage(itemView.getCurrentPage() + 1);
				itemView.appendNewItems(target, itemViewContainer);
			}
		};
		this.add(showMoreLink);

		this.add(new ScrollToBottomBehavior(0) {

			@Override
			protected void respond(AjaxRequestTarget target) {

				if (itemView.getPageCount() > itemView.getCurrentPage() + 1) {
					itemView.setCurrentPage(itemView.getCurrentPage() + 1);
					itemView.appendNewItems(target, itemViewContainer);
				}
			}
		});
	}


	@Override
	public void renderHead(IHeaderResponse response) {

		super.renderHead(response);

		// response.render(CssHeaderItem.forCSS(
		// "#scrollContainer { height: 300px; overflow-y: scroll; };",
		// "scrollContainerStyle"));
	}

}
