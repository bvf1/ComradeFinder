package is.hi.comradefinder.Persistence.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ad {
    @Id
    private long id;
    private String title;
    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> description;
    @ElementCollection(fetch= FetchType.LAZY)
    private List<String> extraQuestions;
    //@OneToOne(mappedBy="ad", cascade= CascadeType.ALL, fetch= FetchType.LAZY, orphanRemoval = true)
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="company_id")
    private Company company;
    private String linkToPDFImage;
    @OneToMany(fetch=FetchType.LAZY)
    private List<Application> applications;
    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> tags;

    // TODO: Do we want to allow empty construction?
    // Constructor chain
    public Ad() {
        this(null, null, null, null, null);
    }
    public Ad(String title, List<String> description, List<String> extraQuestions, Company company, String linkToPDFImage) {
        // TODO: Implement a way for ads to fetch a unique ID.
        //this.id = fetchNewAdID();
        this.title = title;
        this.description = description;
        this.extraQuestions = extraQuestions;
        this.company = company;
        this.linkToPDFImage = linkToPDFImage;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }
    public void addTags(List<String> tags) {
        this.tags.addAll(tags);
    }

    public void removeTag(String tag) {
        this.tags.remove(tag);
    }
    public void removeTags(List<String> tags) {
        this.tags.removeAll(tags);
    }

    //TODO: Getters and setters
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
