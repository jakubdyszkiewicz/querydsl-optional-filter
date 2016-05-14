package org.jakubd.filtering.filter;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;
import org.jakubd.filtering.domain.QPost;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

public class PostFilterOldBuilder {

    private final QPost POST = QPost.post;

    public Predicate build(PostFilter filter) {
        BooleanBuilder builder = new BooleanBuilder(POST.isNotNull());
        if (!StringUtils.isEmpty(filter.getAuthor())) {
            builder.and(POST.author.containsIgnoreCase(filter.getAuthor()));
        }
        if (!StringUtils.isEmpty(filter.getTitle())) {
            builder.and(POST.title.containsIgnoreCase(filter.getTitle()));
        }
        if (filter.getFrom() != null) {
            builder.and(POST.date.after(filter.getFrom()));
        }
        if (filter.getTo() != null) {
            builder.and(POST.date.before(filter.getTo()));
        }
        if (!CollectionUtils.isEmpty(filter.getTags())) {
            builder.and(POST.tags.any().name.in(filter.getTags()));
        }
        return builder;
    }
}
