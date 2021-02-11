package net.dontdrinkandroot.wicket.bootstrap.css

import net.dontdrinkandroot.wicket.css.CssClass

class Spacing(
    private var property: Property,
    private var size: Size,
    private var sides: Side? = null,
    private var breakpoint: Breakpoint? = null
) : CssClass {

    override val classString: String
        get() {
            val classString = StringBuilder(property.value)
            if (null != sides) {
                classString.append(sides!!.value)
            }
            if (null != breakpoint) {
                classString.append("-")
                classString.append(breakpoint!!.classString)
            }
            classString.append("-")
            classString.append(size.value)
            return classString.toString()
        }

    enum class Property(val value: String) {
        MARGIN("m"),
        PADDING("p");
    }

    enum class Side(val value: String) {
        TOP("t"),
        BOTTOM("b"),
        START("s"),
        END("e"),
        X("x"),
        Y("y");
    }

    enum class Size(val value: String) {
        NONE("0"),
        QUARTER("1"),
        HALF("2"),
        FULL("3"),
        ONEHALF("4"),
        THRICE("5"),
        AUTO("auto");
    }

    companion object {

        val MARGIN_BOTTOM_HALF = Spacing(Spacing.Property.MARGIN, Spacing.Size.HALF, Spacing.Side.BOTTOM)
        val MARGIN_BOTTOM_FULL = Spacing(Spacing.Property.MARGIN, Spacing.Size.FULL, Spacing.Side.BOTTOM)
    }
}