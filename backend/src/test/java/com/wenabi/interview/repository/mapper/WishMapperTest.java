package com.wenabi.interview.repository.mapper;

import com.wenabi.interview.domain.Wish;
import com.wenabi.interview.repository.jpa.CompanyJpa;
import com.wenabi.interview.repository.jpa.InitiativeJpa;
import com.wenabi.interview.repository.jpa.ProfileJpa;
import com.wenabi.interview.repository.jpa.WishJpa;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class WishMapperTest {

    @Test
    void mapToWish_aNullWish_givesNothing() {
        WishMapper instance = new WishMapperImpl();

        Wish result = instance.mapToWish(null);

        assertThat(result).isNull();
    }

    @Test
    void mapToWish_aCompleteWishJpa_givesADeeplyMappedWish() {
        WishMapper instance = new WishMapperImpl();
        CompanyJpa companyJpa = new CompanyJpa().setId(1L).setName("MyCompany1");
        CompanyJpa companyJpa2 = new CompanyJpa().setId(1L).setName("MyCompany2");
        ProfileJpa volunteerProfile = new ProfileJpa().setId(1L).setCompany(companyJpa).setFirstName("John").setLastName("Doe");
        ProfileJpa coordinatorProfile = new ProfileJpa().setId(2L).setCompany(companyJpa2).setFirstName("Admin").setLastName("Asso");
        InitiativeJpa initiativeJpa = new InitiativeJpa().setId(1L).setTitle("Distribuer des repas chauds le soir aux plus démunis")
                .setCity("Paris").setStreetName("17 rue des lilas").setPostalCode("75000").setCountry("FR").setCoordinatorProfile(coordinatorProfile);
        WishJpa wishJpa = new WishJpa().setId(1L).setStatus("DISCUSSION").setCreatedDate(ZonedDateTime.now()).setInitiative(initiativeJpa).setVolunteerProfile(volunteerProfile);

        Wish result = instance.mapToWish(wishJpa);

        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getStatus()).isEqualTo("DISCUSSION");
        assertThat(result.getCreatedDate()).isBeforeOrEqualTo(ZonedDateTime.now());
        assertThat(result.getInitiative()).isNotNull();
        assertThat(result.getInitiative().getCity()).isEqualTo("Paris");
        assertThat(result.getInitiative().getCoordinatorProfile().getFirstName()).isEqualTo("Admin");
        assertThat(result.getInitiative().getCoordinatorProfile().getCompany().getName()).isEqualTo("MyCompany2");
        assertThat(result.getVolunteerProfile().getFirstName()).isEqualTo("John");
        assertThat(result.getVolunteerProfile().getCompany().getName()).isEqualTo("MyCompany1");
    }
}
