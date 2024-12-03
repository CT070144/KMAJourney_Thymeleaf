package nguyenvanphuc.KMAJourey.repository;

import nguyenvanphuc.KMAJourey.entity.HocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HocPhanRepository extends JpaRepository<HocPhan, String> {


}
