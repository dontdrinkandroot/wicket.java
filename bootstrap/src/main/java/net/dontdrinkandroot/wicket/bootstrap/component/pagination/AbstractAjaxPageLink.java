package net.dontdrinkandroot.wicket.bootstrap.component.pagination;

import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.ComponentTag;


public abstract class AbstractAjaxPageLink extends AjaxLink<Void> {

	public AbstractAjaxPageLink(String id) {

		super(id);
		this.setBeforeDisabledLink("");
		this.setAfterDisabledLink("");
	}


	@Override
	protected void disableLink(ComponentTag tag) {

		tag.setName("span");

		/* Remove any href from the old link */
		tag.remove("href");

		/* Remove onclick from the old link */
		tag.remove("onclick");
	}
}
