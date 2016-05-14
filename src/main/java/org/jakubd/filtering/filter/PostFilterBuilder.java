package org.jakubd.filtering.filter;

import com.mysema.query.types.Predicate;

public interface PostFilterBuilder {
    Predicate build(PostFilter filter);
}
