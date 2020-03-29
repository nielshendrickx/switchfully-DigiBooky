package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.exceptions.EmailAlreadyRegisteredException;
import com.switchfully.javadocjuveniles.domain.exceptions.InssAlreadyRegisteredException;
import com.switchfully.javadocjuveniles.domain.exceptions.MemberNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemberRepository {
    private final ConcurrentHashMap<String, Member> memberRepository;

    public MemberRepository() {
        this.memberRepository = new ConcurrentHashMap<>();
        createDefaultData();
    }

    public Collection<Member> getAllMembers() {
        return memberRepository.values();
    }

    public Member getMemberByEmail(String email) {
        return memberRepository.values().stream()
                .filter(member -> (member.getEmail().equals(email)))
                .findFirst()
                .orElseThrow(MemberNotFoundException::new);
    }

    public boolean isEmailAvailable(String email) {
        if (memberRepository.values().stream()
                .anyMatch(member -> member.getEmail().equals(email))) {
            throw new EmailAlreadyRegisteredException(email);
        }
        return true;
    }

    public boolean isInssAvailable(String inss) {
        if (memberRepository.values().stream()
        .anyMatch(member -> member.getINSS().equals(inss))) {
            throw new InssAlreadyRegisteredException(inss);
        }
        return true;
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

    public Member registerNewMember(Member newMember) {
        memberRepository.put(newMember.getId(), newMember);
        return newMember;
    }

    public Member getMemberById(String id) {
        return memberRepository.get(id);
    }
}
