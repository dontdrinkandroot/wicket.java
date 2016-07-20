package net.dontdrinkandroot.wicket.example.component;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.wicket.bootstrap.component.item.AbstractLinkItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.DropDownItem;
import net.dontdrinkandroot.wicket.example.ExampleWebSession;


public class ThemeDropDownItem extends DropDownItem
{

	public ThemeDropDownItem(String id)
	{
		super(id, Model.of("Themes"));
	}

	@Override
	protected void populateItems(RepeatingView itemView)
	{
		itemView.add(
				this.createThemeLinkItem(
						itemView.newChildId(),
						"Vanilla",
						"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"));

		itemView.add(
				this.createThemeLinkItem(
						itemView.newChildId(),
						"Cerulean",
						"https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cerulean/bootstrap.min.css"));
		itemView.add(
				this.createThemeLinkItem(
						itemView.newChildId(),
						"Cosmo",
						"https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cosmo/bootstrap.min.css"));
		itemView.add(
				this.createThemeLinkItem(
						itemView.newChildId(),
						"Cyborg",
						"https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cyborg/bootstrap.min.css"));
		itemView.add(
				this.createThemeLinkItem(
						itemView.newChildId(),
						"Darkly",
						"https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/darkly/bootstrap.min.css"));
		itemView.add(
				this.createThemeLinkItem(
						itemView.newChildId(),
						"Flatly",
						"https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/flatly/bootstrap.min.css"));
		itemView.add(
				this.createThemeLinkItem(
						itemView.newChildId(),
						"Journal",
						"https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/journal/bootstrap.min.css"));
		itemView.add(
				this.createThemeLinkItem(
						itemView.newChildId(),
						"Lumen",
						"https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/lumen/bootstrap.min.css"));
		itemView.add(
				this.createThemeLinkItem(
						itemView.newChildId(),
						"Paper",
						"https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/paper/bootstrap.min.css"));
		itemView.add(
				this.createThemeLinkItem(
						itemView.newChildId(),
						"Readable",
						"https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/readable/bootstrap.min.css"));
		itemView.add(
				this.createThemeLinkItem(
						itemView.newChildId(),
						"Sandstone",
						"https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/sandstone/bootstrap.min.css"));
		itemView.add(
				this.createThemeLinkItem(
						itemView.newChildId(),
						"Simplex",
						"https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/simplex/bootstrap.min.css"));
		itemView.add(
				this.createThemeLinkItem(
						itemView.newChildId(),
						"Slate",
						"https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/slate/bootstrap.min.css"));
		itemView.add(
				this.createThemeLinkItem(
						itemView.newChildId(),
						"Spacelab",
						"https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/spacelab/bootstrap.min.css"));
		itemView.add(
				this.createThemeLinkItem(
						itemView.newChildId(),
						"Superhero",
						"https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/superhero/bootstrap.min.css"));
		itemView.add(
				this.createThemeLinkItem(
						itemView.newChildId(),
						"United",
						"https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/united/bootstrap.min.css"));
		itemView.add(
				this.createThemeLinkItem(
						itemView.newChildId(),
						"Yeti",
						"https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/yeti/bootstrap.min.css"));
	}

	protected AbstractLinkItem createThemeLinkItem(String id, String name, final String url)
	{
		AbstractLinkItem themeLinkItem = new AbstractLinkItem(id, Model.of(name)) {

			@Override
			protected Component createLink(String id)
			{
				AjaxLink<Void> themeLink = new AjaxLink<Void>(id) {

					@Override
					public void onClick(AjaxRequestTarget target)
					{
						ExampleWebSession.get().setCurrentThemeUrl(url);
						this.setResponsePage(this.getPage());
					}
				};
				themeLink.setBody(Model.of(this.getModel()));
				return themeLink;
			}

		};
		return themeLinkItem;
	}

}
