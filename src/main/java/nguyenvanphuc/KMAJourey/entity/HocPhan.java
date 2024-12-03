package nguyenvanphuc.KMAJourey.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HocPhan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String tenHocPhan;
    double diemThanhPhan1;
    double diemThanhPhan2;
    double diemThi;
    double diemTongKet;
    String diemChu;
    int hocKi = 0;
    int soTinchi = 0;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sinhvien_id")
    SinhVien sinhVien;
}
