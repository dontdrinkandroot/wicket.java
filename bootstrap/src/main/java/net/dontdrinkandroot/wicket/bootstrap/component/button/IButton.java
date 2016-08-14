package net.dontdrinkandroot.wicket.bootstrap.component.button;

import org.apache.wicket.model.IModel;
import org.apache.wicket.util.io.IClusterable;

import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;


public interface IButton
{

	ButtonSize getButtonSize();

	IClusterable setButtonSize(ButtonSize buttonSize);

	IClusterable setButtonSizeModel(IModel<ButtonSize> buttonSizeModel);

	ButtonStyle getButtonStyle();

	IClusterable setButtonStyle(ButtonStyle buttonStyle);

	IClusterable setButtonStyleModel(IModel<ButtonStyle> buttonStyleModel);

}
