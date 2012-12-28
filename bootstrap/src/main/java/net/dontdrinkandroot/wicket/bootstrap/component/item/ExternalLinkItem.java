package net.dontdrinkandroot.wicket.bootstrap.component.item;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.UrlUtils;


public class ExternalLinkItem extends AbstractLinkItem {

	private final IModel<String> hrefModel;


	public ExternalLinkItem(String id, IModel<String> hrefModel, IModel<String> labelModel) {

		super(id, labelModel);
		this.hrefModel = hrefModel;
	}


	@Override
	protected Component createLink(String id) {

		ExternalLink link = new ExternalLink(id, this.hrefModel);

		link.add(new AttributeModifier("rel", new AbstractReadOnlyModel<String>() {

			@Override
			public String getObject() {

				if (UrlUtils.isRelative(ExternalLinkItem.this.hrefModel.getObject())) {
					return null;
				}
				return "external";
			}
		}));
		link.setBody(this.getModel());
		return link;
	}

}
