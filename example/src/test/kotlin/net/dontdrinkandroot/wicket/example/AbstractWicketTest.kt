package net.dontdrinkandroot.wicket.example

import org.apache.wicket.Component
import org.apache.wicket.MarkupContainer
import org.apache.wicket.util.tester.WicketTester
import org.apache.wicket.util.visit.IVisit
import org.apache.wicket.util.visit.IVisitor
import org.apache.wicket.util.visit.Visits
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@SpringBootTest(classes = [Application::class])
abstract class AbstractWicketTest
{
    @Autowired
    protected var wicketApplication: ExampleWebApplication? = null

    protected lateinit var tester: WicketTester

    @BeforeEach
    fun setUp()
    {
        tester = WicketTester(wicketApplication)
    }

    @AfterEach
    fun tearDown()
    {
        tester.destroy()
    }

    protected fun assertStateless(component: MarkupContainer?)
    {
        Visits.visitChildren(component, IVisitor { component1: Component, visit: IVisit<Void?>? ->
            if (!component1.isStateless)
            {
                Assertions.assertTrue(
                    component1.isStateless, String.format(
                        "Component '%s' is not stateless. Type: %s, Path: %s",
                        component1.markupId,
                        component1.javaClass.canonicalName,
                        component1.path
                    )
                )
            }
        } as IVisitor<Component, Void?>)
    }
}