package org.jakubd.filtering

import org.jakubd.filtering.filter.PostFilterBuilder
import org.jakubd.filtering.filter.PostFilterOldBuilder

class PostFilterOldBuilderTest extends PostFilterTest {

    @Override
    PostFilterBuilder getFilterBuilder() {
        new PostFilterOldBuilder()
    }
}
