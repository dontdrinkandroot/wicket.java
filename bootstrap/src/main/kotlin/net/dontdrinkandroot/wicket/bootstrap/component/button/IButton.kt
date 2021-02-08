package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import net.dontdrinkandroot.wicket.model.KModel
import org.apache.wicket.util.io.IClusterable

interface IButton {

    fun getButtonSize(): ButtonSize?
    fun setButtonSize(buttonSize: ButtonSize?): IClusterable
    fun setButtonSizeModel(buttonSizeModel: KModel<ButtonSize?>): IClusterable

    fun getButtonStyle(): ButtonStyle
    fun setButtonStyle(buttonStyle: ButtonStyle): IClusterable
    fun setButtonStyleModel(buttonStyleModel: KModel<ButtonStyle>): IClusterable
}