package lib_mg.Service;


import lib_mg.Repository.Member;
import lib_mg.Repository.Memberrepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberService {
    private final Memberrepo memberRepository;

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }
    public Member updateMember(Long id, Member member) {
        Member existingMember = getMemberById(id);

        existingMember.setName(member.getName());
        existingMember.setEmail(member.getEmail());
        existingMember.setPhone(member.getPhone());
        existingMember.setMembershipDate(member.getMembershipDate());

        return memberRepository.save(existingMember);
    }
    public void deleteMember(Long id) {
        getMemberById(id);
        memberRepository.deleteById(id);
    }
}
