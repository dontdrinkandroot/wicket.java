package net.dontdrinkandroot.wicket.bootstrap.component.pagination;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.css.PaginationSize;


public class BookmarkablePaginationPanel extends PaginationPanel
{

	public BookmarkablePaginationPanel(String id, IPageable pageable)
	{
		super(id, pageable, null);
	}

	public BookmarkablePaginationPanel(String id, IPageable pageable, PaginationSize size)
	{
		super(id, pageable, size);
	}

	@Override
	protected AbstractLink createLink(String id, final IModel<Long> paginablePageModel)
	{
		return new BookmarkablePageLink<Long>(id, Page.class) {

			@Override
			public PageParameters getPageParameters()
			{
				PageParameters parameters = new PageParameters(this.getPage().getPageParameters());
				/* Zero based page index */
				parameters.set("page", paginablePageModel.getObject() + 1);
				return parameters;
			}

			@Override
			protected CharSequence getURL()
			{
				PageParameters parameters = this.getPageParameters();

				return this.urlFor(this.getPage().getClass(), parameters);
			}
		};
	}
}
