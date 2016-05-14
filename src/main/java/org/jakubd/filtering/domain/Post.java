package org.jakubd.filtering.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Post {
    @Id
    private Integer id;
    private String author;
    private String title;
    private String body;
    private LocalDate date;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "post_tags", joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    private List<Tag> tags;
}
