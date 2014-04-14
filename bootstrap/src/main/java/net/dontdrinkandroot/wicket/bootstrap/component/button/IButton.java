package net.dontdrinkandroot.wicket.bootstrap.component.button;

import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;

import org.apache.wicket.util.io.IClusterable;


public interface IButton {

	ButtonSize getButtonSize();


	IClusterable setButtonSize(ButtonSize buttonSize);


	ButtonStyle getButtonStyle();


	IClusterable setButtonStyle(ButtonStyle buttonStyle);

}
