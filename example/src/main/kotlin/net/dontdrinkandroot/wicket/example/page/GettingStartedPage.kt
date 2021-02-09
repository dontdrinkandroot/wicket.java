package net.dontdrinkandroot.wicket.example.page

import net.dontdrinkandroot.wicket.model.model

class GettingStartedPage : DecoratorPage<Void>() {

    override fun createPageHeadingModel() = "Getting started".model()
}