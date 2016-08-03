package net.dontdrinkandroot.wicket.example.page.component;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.component.pagination.AjaxPaginationPanel;
import net.dontdrinkandroot.wicket.bootstrap.component.pagination.PaginationPanel;


public class PaginationPage extends ComponentPage
{

	public PaginationPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		IPageable pageable = new IPageable() {

			private long currentPage;


			@Override
			public void setCurrentPage(long page)
			{
				this.currentPage = page;
			}

			@Override
			public long getPageCount()
			{
				return 20;
			}

			@Override
			public long getCurrentPage()
			{
				return this.currentPage;
			}
		};

		Label currentPageLabel = new Label("currentPage", new AbstractReadOnlyModel<String>() {

			@Override
			public String getObject()
			{
				return Long.toString(pageable.getCurrentPage());
			}
		});
		currentPageLabel.setOutputMarkupId(true);
		this.add(currentPageLabel);

		PaginationPanel pagination = new PaginationPanel("pagination", pageable);
		this.add(pagination);

		AjaxPaginationPanel ajaxPagination = new AjaxPaginationPanel("ajaxPagination", pageable) {

			@Override
			protected void onPageChanged(AjaxRequestTarget target)
			{
				super.onPageChanged(target);
				target.add(currentPageLabel);
			}
		};
		this.add(ajaxPagination);
	}

	@Override
	protected IModel<String> createPageHeadingModel()
	{
		return Model.of("Pagination");
	}
}
