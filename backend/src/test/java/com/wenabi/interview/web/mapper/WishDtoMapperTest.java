package com.wenabi.interview.web.mapper;

import com.wenabi.interview.domain.Company;
import com.wenabi.interview.domain.Initiative;
import com.wenabi.interview.domain.Profile;
import com.wenabi.interview.domain.Wish;
import com.wenabi.interview.web.response.WishOutputDto;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class WishDtoMapperTest {

    @Test
    void mapToWishOutputDto_withANullWish_givesNothing() {
        WishDtoMapper instance = new WishDtoMapperImpl();

        WishOutputDto result = instance.mapToWishOutputDto(null);

        assertThat(result).isNull();
    }


    @Test
    void mapToWishOutputDto_aCompleteWish_givesADeeplyMappedWishOutputDto() {
        WishDtoMapper instance = new WishDtoMapperImpl();
        Company company = Company.builder().id(1L).name("MyCompany1").build();
        Company company2 = Company.builder().id(1L).name("MyCompany2").build();
        Profile volunteerProfile = Profile.builder().id(1L).company(company).firstName("John").lastName("Doe").build();
        Profile coordinatorProfile = Profile.builder().id(2L).company(company2).firstName("Admin").lastName("Asso").build();
        Initiative initiative = Initiative.builder().id(1L).title("Distribuer des repas chauds le soir aux plus démunis")
                .city("Paris").streetName("17 rue des lilas").postalCode("75000").country("FR").coordinatorProfile(coordinatorProfile).build();
        Wish wish = Wish.builder().id(1L).status("DISCUSSION").createdDate(ZonedDateTime.now()).initiative(initiative).volunteerProfile(volunteerProfile).build();

        WishOutputDto result = instance.mapToWishOutputDto(wish);

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
