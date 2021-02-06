package net.dontdrinkandroot.wicket.example

import net.dontdrinkandroot.wicket.example.model.Theme
import net.dontdrinkandroot.wicket.example.model.availableThemes
import org.apache.wicket.Session
import org.apache.wicket.protocol.http.WebSession
import org.apache.wicket.request.Request

fun getCurrentSession() = Session.get() as ExampleWebSession

class ExampleWebSession(request: Request?) : WebSession(request) {

    var currentTheme: Theme? = null
        get() {
            if (null == field) {
                field = availableThemes().iterator().next()
            }
            return field
        }
}