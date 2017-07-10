package org.ogin.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ogin
 */
@Entity
@Table(name = "Category")
public class Category implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    Category parent;

    @OneToMany(mappedBy = "parent")
    @OrderBy("id")
    List<Category> children = new ArrayList<Category>();

    public void appendChildren(Category c) {
        this.children.add(c);
    }

    public String getDisplayName() {
        if (parent != null) {
            return parent.getDisplayName() + " : " + name;
        } else {
            return name;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }
}
