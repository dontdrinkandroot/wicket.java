/*
 * Copyright (C) 2012-2017 Philip Washington Sorst <philip@sorst.net>
 * and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.bootstrap.component.pagination.AjaxPaginationPanel
import net.dontdrinkandroot.wicket.bootstrap.component.pagination.PaginationPanel
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.navigation.paging.IPageable
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
class PaginationPage(parameters: PageParameters?) : ComponentPage(parameters)
{
    override fun onInitialize()
    {
        super.onInitialize()
        val pageable: IPageable = object : IPageable
        {
            private var currentPage: Long = 0
            override fun setCurrentPage(page: Long)
            {
                currentPage = page
            }

            override fun getPageCount(): Long
            {
                return 20
            }

            override fun getCurrentPage(): Long
            {
                return currentPage
            }
        }
        val currentPageLabel = Label("currentPage") { java.lang.Long.toString(pageable.currentPage) }
        currentPageLabel.outputMarkupId = true
        this.add(currentPageLabel)
        val pagination = PaginationPanel("pagination", pageable)
        this.add(pagination)
        val ajaxPagination: AjaxPaginationPanel = object : AjaxPaginationPanel("ajaxPagination", pageable)
        {
            override fun onPageChanged(target: AjaxRequestTarget)
            {
                super.onPageChanged(target)
                target.add(currentPageLabel)
            }
        }
        this.add(ajaxPagination)
    }

    override fun createPageHeadingModel(): IModel<String>
    {
        return Model.of("Pagination")
    }
}