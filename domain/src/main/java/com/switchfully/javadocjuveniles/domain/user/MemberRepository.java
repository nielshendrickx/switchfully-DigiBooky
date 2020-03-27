package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.user.builders.AddressBuilder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Repository
public class MemberRepository {
    private final ArrayList<Member> memberRepository;

    public MemberRepository() {
        this.memberRepository = new ArrayList<>();
        createDefaultData();
    }

    public Collection<Member> getAllMembers() {
        return memberRepository;
    }

    private void createDefaultData() {
/*        Member member1 = MemberBuilder.memberBuilder()
                .withPersonalInfo(PersonalInfoBuilder.personalInfoBuilder()
                        .withFirstName("John")
                        .withLastName("Doe")
                        .withEmail("john.doe@dead.com")
                        .withPassWord("dead")
                        .build()
                )
                .setAddress(AddressBuilder.addressBuilder()
                        .withCity("Brussels")
                        .withPostalCode("1000")
                        .withStreet("Helihavanlaan")
                        .withStreetNumber("22")
                        .build()
                )
                .withINSS("63.07.13-123.45")
                .buildMember();
        Member member2 = MemberBuilder.memberBuilder()
                .withPersonalInfo(PersonalInfoBuilder.personalInfoBuilder()
                        .withFirstName("JAne")
                        .withLastName("Doe")
                        .withEmail("jane.doe@dead.com")
                        .withPassWord("dead")
                        .build()
                )
                .setAddress(AddressBuilder.addressBuilder()
                        .withCity("Brussels")
                        .withPostalCode("1000")
                        .withStreet("Helihavanlaan")
                        .withStreetNumber("22")
                        .build()
                )
                .withINSS("72.12.24-123.45")
                .buildMember();
        Member member3 = MemberBuilder.memberBuilder()
                .withPersonalInfo(PersonalInfoBuilder.personalInfoBuilder()
                        .withFirstName("Claude")
                        .withLastName("Dubois")
                        .withEmail("imascubadiver@lol.com")
                        .withPassWord("divingforfun")
                        .build()
                )
                .setAddress(AddressBuilder.addressBuilder()
                        .withCity("Paris")
                        .withPostalCode("75001")
                        .withStreet("Place de la Concorde")
                        .withStreetNumber("1")
                        .build()
                )
                .withINSS("88.07.22-123.45")
                .buildMember();
        memberRepository.addAll(Arrays.asList(member1, member2, member3));*/
    }
}
