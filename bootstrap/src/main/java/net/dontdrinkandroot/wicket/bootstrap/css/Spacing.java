package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class Spacing implements CssClass
{
    private Property property;

    private Side side;

    private Size size;

    public Spacing(Property property, Size size)
    {
        this.property = property;
        this.size = size;
    }

    public Spacing(Property property, Side side, Size size)
    {
        this.property = property;
        this.side = side;
        this.size = size;
    }

    @Override
    public String getClassString()
    {
        StringBuilder classString = new StringBuilder(this.property.getValue());
        if (null != this.side) {
            classString.append(this.side.getValue());
        }
        classString.append("-");
        classString.append(this.size.getValue());

        return classString.toString();
    }

    public enum Property
    {
        MARGIN("m"),
        PADDING("");

        private final String value;

        Property(String value)
        {
            this.value = value;
        }

        public String getValue()
        {
            return this.value;
        }
    }

    public enum Side
    {
        TOP("t"),
        BOTTOM("b"),
        LEFT("l"),
        RIGHT("r"),
        X("x"),
        Y("y");

        private final String value;

        Side(String value)
        {
            this.value = value;
        }

        public String getValue()
        {
            return this.value;
        }
    }

    public enum Size
    {
        ZERO("0"),
        QUARTER("1"),
        HALF("2"),
        FULL("3"),
        ONEHALF("4"),
        THREE("3"),
        AUTO("auto");

        private final String value;

        Size(String value)
        {
            this.value = value;
        }

        public String getValue()
        {
            return this.value;
        }
    }
}
