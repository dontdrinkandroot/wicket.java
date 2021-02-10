package net.dontdrinkandroot.wicket.example

class ExampleTestApplication : ExampleWebApplication()
{
    override fun init()
    {
        super.init()
        markupSettings.stripWicketTags = false
    }
}