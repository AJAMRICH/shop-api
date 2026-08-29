package sk.ajamrich.shopapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ord")
public class Ord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ordnum;

    @Column(nullable = false)
    private String stcust;

    public Ord() {}

    public Ord(String ordnum, String stcust) {
        this.ordnum = ordnum;
        this.stcust = stcust;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getOrdnum() { return ordnum; }
    public void setOrdnum(String ordnum) { this.ordnum = ordnum; }
    public String getStcust() { return stcust; }
    public void setStcust(String stcust) { this.stcust = stcust; }
}