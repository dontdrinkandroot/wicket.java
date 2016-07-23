package net.dontdrinkandroot.wicket.bootstrap.component.item;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.model.IModel;


public abstract class AjaxLinkItem extends AbstractLinkItem
{

	public AjaxLinkItem(String id, String label)
	{
		super(id, label);
	}

	public AjaxLinkItem(String id, IModel<String> labelModel)
	{
		super(id, labelModel);
	}

	@Override
	protected Component createLink(String id)
	{
		AjaxLink<Void> link = new AjaxLink<Void>(id) {

			@Override
			public void onClick(AjaxRequestTarget target)
			{
				AjaxLinkItem.this.onClick(target);
			}
		};
		link.setBody(this.getModel());

		return link;
	}

	protected abstract void onClick(AjaxRequestTarget target);

}
