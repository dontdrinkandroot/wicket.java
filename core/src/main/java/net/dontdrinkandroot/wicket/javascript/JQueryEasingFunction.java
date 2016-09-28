package net.dontdrinkandroot.wicket.javascript;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public enum JQueryEasingFunction implements EasingFunction
{
    LINEAR("linear"),
    SWING("swing");

    private final String name;

    private JQueryEasingFunction(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
