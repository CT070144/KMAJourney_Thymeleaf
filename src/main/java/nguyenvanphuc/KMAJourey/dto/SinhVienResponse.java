package nguyenvanphuc.KMAJourey.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import nguyenvanphuc.KMAJourey.entity.SinhVien;
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SinhVienResponse {
    SinhVien sinhVien;
    int completed;
    int incomplete;
    double GPA;
    int top;


}
