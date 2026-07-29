package lib_mg.Controller;


import lib_mg.Repository.Loan;
import lib_mg.Service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
@AllArgsConstructor
public class LoanController {

    private final LoanService loanService;

    // Issue a book to a member
    @PostMapping("/issue")
    public ResponseEntity<Loan> issueBook(
            @RequestParam Long memberId,
            @RequestParam Long bookId) {

        Loan loan = loanService.issueBook(memberId, bookId);

        return ResponseEntity.ok(loan);
    }

    // Return a book
    @PutMapping("/{loanId}/return")
    public ResponseEntity<Loan> returnBook(
            @PathVariable Long loanId) {

        Loan returnedLoan = loanService.returnBook(loanId);

        return ResponseEntity.ok(returnedLoan);
    }

    // Get all loans
    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {

        List<Loan> loans = loanService.getAllLoans();

        return ResponseEntity.ok(loans);
    }

    // Get a loan using ID
    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(
            @PathVariable Long id) {

        Loan loan = loanService.getLoanById(id);

        return ResponseEntity.ok(loan);
    }

    // Delete a loan
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLoan(
            @PathVariable Long id) {

        loanService.deleteLoan(id);

        return ResponseEntity.ok("Loan deleted successfully");
    }
}
