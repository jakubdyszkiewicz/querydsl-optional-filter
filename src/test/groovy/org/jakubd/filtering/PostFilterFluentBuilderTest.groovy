package org.jakubd.filtering

import org.jakubd.filtering.filter.PostFilterBuilder
import org.jakubd.filtering.filter.PostFilterFluentBuilder

class PostFilterFluentBuilderTest extends PostFilterTest {

    @Override
    PostFilterBuilder getFilterBuilder() {
        new PostFilterFluentBuilder()
    }
}
