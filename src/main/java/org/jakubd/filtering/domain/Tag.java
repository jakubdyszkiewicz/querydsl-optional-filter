package org.jakubd.filtering.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
public class Tag {
    @Id
    private Integer id;
    private String name;
    @ManyToMany(mappedBy = "tags")
    private List<Post> posts;
}
