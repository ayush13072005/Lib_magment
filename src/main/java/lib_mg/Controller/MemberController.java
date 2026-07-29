package lib_mg.Controller;


import lib_mg.Repository.Member;
import lib_mg.Service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    // Add a new member
    @PostMapping
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        Member savedMember = memberService.saveMember(member);
        return ResponseEntity.ok(savedMember);
    }

    // Get all members
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    // Get a member using ID
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(
            @PathVariable Long id) {

        Member member = memberService.getMemberById(id);

        return ResponseEntity.ok(member);
    }

    // Update a member
    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(
            @PathVariable Long id,
            @RequestBody Member member) {

        Member updatedMember =
                memberService.updateMember(id, member);

        return ResponseEntity.ok(updatedMember);
    }

    // Delete a member
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember( @PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok("Member deleted successfully");
    }
}