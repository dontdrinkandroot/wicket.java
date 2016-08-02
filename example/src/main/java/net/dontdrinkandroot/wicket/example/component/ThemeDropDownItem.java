package net.dontdrinkandroot.wicket.example.component;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.wicket.bootstrap.component.item.AbstractLinkItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.DropDownItem;
import net.dontdrinkandroot.wicket.example.ExampleWebSession;
import net.dontdrinkandroot.wicket.example.model.Theme;
import net.dontdrinkandroot.wicket.model.ConcatenatingStringModel;


public class ThemeDropDownItem extends DropDownItem
{

	public ThemeDropDownItem(String id)
	{
		super(id, new ConcatenatingStringModel(Model.of("Theme"), ": ", new AbstractReadOnlyModel<String>() {

			@Override
			public String getObject()
			{
				return ExampleWebSession.get().getCurrentTheme().getName();
			}
		}));
	}

	@Override
	protected void populateItems(RepeatingView itemView)
	{
		for (Theme theme : Theme.getAvailableThemes()) {
			itemView.add(this.createThemeLinkItem(itemView.newChildId(), theme));
		}
	}

	protected AbstractLinkItem createThemeLinkItem(String id, Theme theme)
	{
		AbstractLinkItem themeLinkItem = new AbstractLinkItem(id, Model.of(theme.getName())) {

			@Override
			protected Component createLink(String id)
			{
				AjaxLink<Void> themeLink = new AjaxLink<Void>(id) {

					@Override
					public void onClick(AjaxRequestTarget target)
					{
						ExampleWebSession.get().setCurrentTheme(theme);
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
