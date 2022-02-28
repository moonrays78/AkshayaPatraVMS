package com.akshayapatravms.c4g.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

// TODO: add organization subgroups
@Entity
@Table(name = "event")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Event extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @OneToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
    private Location location;

    @Size(max = 1000)
    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "volunteers_needed_amount")
    private Integer volunteersNeededAmount;

    @OneToOne
    @JoinColumn(name = "event_creator_id", referencedColumnName = "id", nullable = false)
    private User eventCreator;

    @Column(name = "start_date_and_time")
    private Instant startDateAndTime;

    @Column(name = "end_date_and_time")
    private Instant endDateAndTime;

    // double check that this works
    @OneToMany
    @JoinColumn(name = "cause_id", referencedColumnName = "id")
    private Set<Cause> causes = new HashSet<>();

    @Size(max = 100)
    @Column(name = "contact_name", length = 100)
    private String contactName;

    @Size(max = 100)
    @Column(name = "contact_phone_number", length = 100)
    private String contactPhoneNumber;

    @Size(max = 100)
    @Column(name = "contact_email", length = 100)
    private String contactEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVolunteersNeededAmount() {
        return volunteersNeededAmount;
    }

    public void setVolunteersNeededAmount(Integer volunteersNeededAmount) {
        this.volunteersNeededAmount = volunteersNeededAmount;
    }

    public User getEventCreator() {
        return eventCreator;
    }

    public void setEventCreator(User eventCreator) {
        this.eventCreator = eventCreator;
    }

    public Instant getStartDateAndTime() {
        return startDateAndTime;
    }

    public void setStartDateAndTime(Instant startDateAndTime) {
        this.startDateAndTime = startDateAndTime;
    }

    public Instant getEndDateAndTime() {
        return endDateAndTime;
    }

    public void setEndDateAndTime(Instant endDateAndTime) {
        this.endDateAndTime = endDateAndTime;
    }

    public Set<Cause> getCauses() {
        return causes;
    }

    public void setCauses(Set<Cause> causes) {
        this.causes = causes;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
    //    @Override
    //    public boolean equals(Object o) {
    //        if (this == o) {
    //            return true;
    //        }
    //        if (!(o instanceof User)) {
    //            return false;
    //        }
    //        return id != null && id.equals(((User) o).id);
    //    }

    //    @Override
    //    public int hashCode() {
    //        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
    //        return getClass().hashCode();
    //    }

    //    // prettier-ignore
    //    @Override
    //    public String toString() {
    //        return "User{" +
    //            "login='" + login + '\'' +
    //            ", firstName='" + firstName + '\'' +
    //            ", lastName='" + lastName + '\'' +
    //            ", email='" + email + '\'' +
    //            ", imageUrl='" + imageUrl + '\'' +
    //            ", activated='" + activated + '\'' +
    //            ", langKey='" + langKey + '\'' +
    //            ", activationKey='" + activationKey + '\'' +
    //            "}";
    //    }

}
