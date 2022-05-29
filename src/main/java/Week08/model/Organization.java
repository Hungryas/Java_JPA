package Week08.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "organizations")
public class Organization {
    @Id
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image")
    private String image;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_person_id")
    private User user;

    @Column(name = "director")
    private String director;

    @Column(name = "inn", nullable = false)
    private String inn;

    @Column(name = "ogrn")
    private String ogrn;

    @Column(name = "kpp")
    private String kpp;

    @Column(name = "okved")
    private String okved;

    @Column(name = "okpo")
    private String okpo;

    @Column(name = "bank")
    private String bank;

    @Column(name = "bik")
    private String bik;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "employees_count")
    private Integer employeesCount;

    @Column(name = "address")
    private String address;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "description")
    private String description;

    public Organization(String id,
                        String name,
                        String image,
                        User user,
                        String director,
                        String inn,
                        String ogrn,
                        String kpp,
                        String okved,
                        String okpo,
                        String bank,
                        String bik,
                        String phone,
                        String email,
                        Integer employeesCount,
                        String address,
                        LocalDateTime creationDate,
                        LocalDateTime updateDate,
                        String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.user = user;
        this.director = director;
        this.inn = inn;
        this.ogrn = ogrn;
        this.kpp = kpp;
        this.okved = okved;
        this.okpo = okpo;
        this.bank = bank;
        this.bik = bik;
        this.phone = phone;
        this.email = email;
        this.employeesCount = employeesCount;
        this.address = address;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Organization organization = (Organization) o;
        return id != null && Objects.equals(id, organization.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
