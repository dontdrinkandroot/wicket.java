package net.dontdrinkandroot.wicket.example.component;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.IMarkupSourcingStrategy;
import org.apache.wicket.markup.html.panel.PanelMarkupSourcingStrategy;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.wicket.bootstrap.behavior.NavBarFormBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxSubmitButton;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupTextField;


public class NavBarForm extends Form<Void>
{

	public NavBarForm(String id)
	{
		super(id);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		this.add(new NavBarFormBehavior());
		FormGroupTextField<String> searchGroup =
				new FormGroupTextField<String>("searchGroup", Model.of("Search"), new Model<String>());
		searchGroup.setLabelScreenReaderOnly(true);
		this.add(searchGroup);
		this.add(new AjaxSubmitButton("submit").setBody(Model.of("Search")));
	}

	@Override
	protected IMarkupSourcingStrategy newMarkupSourcingStrategy()
	{
		return new PanelMarkupSourcingStrategy(false);
	}

}
