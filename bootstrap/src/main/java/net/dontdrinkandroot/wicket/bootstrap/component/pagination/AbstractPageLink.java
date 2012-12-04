package net.dontdrinkandroot.wicket.bootstrap.component.pagination;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.link.Link;


public abstract class AbstractPageLink extends Link<Void> {

	public AbstractPageLink(String id) {

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
