package net.dontdrinkandroot.wicket.component.form;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.LabeledWebMarkupContainer;
import org.apache.wicket.markup.parser.XmlTag.TagType;
import org.apache.wicket.util.string.Strings;


public class FormComponentLabel extends Label
{

	private FormComponent<?> formComponent;


	public FormComponentLabel(String id, FormComponent<?> formComponent)
	{
		super(id, formComponent.getLabel());
		this.formComponent = formComponent;
	}

	@Override
	protected void onConfigure()
	{
		super.onConfigure();
		this.setVisible((this.getDefaultModel() != null) && !Strings.isEmpty(this.getDefaultModelObjectAsString()));
	}

	@Override
	protected void onComponentTag(ComponentTag tag)
	{
		super.onComponentTag(tag);

		LabeledWebMarkupContainer formComponent = this.getFormComponent();
		tag.put("for", formComponent.getMarkupId());
		tag.setType(TagType.OPEN);
	}

	public LabeledWebMarkupContainer getFormComponent()
	{
		return this.formComponent;
	}
}
