package nguyenvanphuc.KMAJourey.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SinhVien {
    @Id
    String maSinhVien;
    String tenSinhVien;
    String lop;
    String khoa;
    String trangThai = "ĐANG HỌC";
    @OneToMany(mappedBy = "sinhVien", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<HocPhan> danhSachHocPhan;
}
