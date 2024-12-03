package nguyenvanphuc.KMAJourey.repository;

import nguyenvanphuc.KMAJourey.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien,String> {
       Optional<SinhVien> findBylop(String lop);
}
