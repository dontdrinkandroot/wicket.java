package net.dontdrinkandroot.wicket.markup.html.link;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class AjaxBookmarkablePageLink<T> extends BookmarkablePageLink<T>
{

	public <C extends Page> AjaxBookmarkablePageLink(String id, Class<C> pageClass)
	{
		super(id, pageClass);
	}

	public <C extends Page> AjaxBookmarkablePageLink(String id, Class<C> pageClass, PageParameters parameters)
	{
		super(id, pageClass, parameters);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		this.add(new AjaxEventBehavior("click") {

			@Override
			protected void onEvent(AjaxRequestTarget target)
			{
				AjaxBookmarkablePageLink.this.onClick(target);
			}

			@Override
			protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
			{
				super.updateAjaxAttributes(attributes);
				attributes.setPreventDefault(true);
				AjaxBookmarkablePageLink.this.updateAjaxAttributes(attributes);
			}
		});
	}

	protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
	{
		/* Hook */
	}

	protected void onClick(AjaxRequestTarget target)
	{
		/* Hook */
	}
}
