package com.example.buoi1.comment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nationalized
    private String content;

    //Comment cha
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id", foreignKey = @ForeignKey(name = "FK_COMMENT_PARENT_CHILDREN"))
    private Comment parentComment;

    //Comment con
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentComment")
    private Set<Comment> childrenComments = new HashSet<>();

}
