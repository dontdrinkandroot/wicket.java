package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import org.apache.wicket.model.IModel
import org.apache.wicket.util.io.IClusterable

interface IButton {

    fun getButtonSize(): ButtonSize?
    fun setButtonSize(buttonSize: ButtonSize?): IClusterable

    @Deprecated("Model will usually be bound already")
    fun setButtonSizeModel(buttonSizeModel: IModel<ButtonSize?>): IClusterable

    fun getButtonStyle(): ButtonStyle
    fun setButtonStyle(buttonStyle: ButtonStyle): IClusterable

    @Deprecated("Model will usually be bound already")
    fun setButtonStyleModel(buttonStyleModel: IModel<ButtonStyle>): IClusterable
}