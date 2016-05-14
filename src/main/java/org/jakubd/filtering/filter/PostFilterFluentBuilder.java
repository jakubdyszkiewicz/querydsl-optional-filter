package org.jakubd.filtering.filter;

import com.mysema.query.types.Predicate;
import org.jakubd.filtering.domain.QPost;

public class PostFilterFluentBuilder implements PostFilterBuilder {

    private final QPost POST = QPost.post;

    public Predicate build(PostFilter filter) {
        return new OptionalBooleanBuilder(POST.isNotNull())
                .notEmptyAnd(POST.author::containsIgnoreCase, filter.getAuthor())
                .notEmptyAnd(POST.title::containsIgnoreCase, filter.getTitle())
                .notNullAnd(POST.date::after, filter.getFrom())
                .notNullAnd(POST.date::before, filter.getTo())
                .notEmptyAnd(POST.tags.any().name::in, filter.getTags())
                .build();
    }
}
