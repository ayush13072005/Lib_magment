package lib_mg.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Categoryrepo extends JpaRepository<Category,String > {
}
