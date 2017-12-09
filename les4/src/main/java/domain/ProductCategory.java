package domain;

import javax.persistence.*;

@Entity
public class ProductCategory {

    @Id
    @Column(name = "CATEGORY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_id_seq_gen") //есть AUTO, IDENTITY, TABLE, SEQUENCE
    @SequenceGenerator(name = "category_id_seq_gen", sequenceName = "category_id_seq")
    private int categoryId;

    @Column(name = "NAME", length = 30, unique = true, nullable = false)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
