package nguyenvanphuc.KMAJourey.service;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import nguyenvanphuc.KMAJourey.dto.SinhVienResponse;
import nguyenvanphuc.KMAJourey.entity.HocPhan;
import nguyenvanphuc.KMAJourey.entity.SinhVien;
import nguyenvanphuc.KMAJourey.exception.AppException;
import nguyenvanphuc.KMAJourey.exception.ErrorCode;
import nguyenvanphuc.KMAJourey.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor //Tự động tạo constructor cho lớp dựa trên các trường final
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
public class SinhVienService {
    @Autowired
    SinhVienRepository sinhVienRepository;

    public SinhVienResponse getSinhVien(String id) {
        SinhVien sinhVien = sinhVienRepository.findById(id)
                .orElseThrow(()-> new AppException(ErrorCode.SV_NOT_EXIT));
        return SinhVienResponse.builder()
                .sinhVien(sinhVien)
                .completed(sinhVien.getDanhSachHocPhan().size())
                .incomplete(getIncomplete(sinhVien.getDanhSachHocPhan()))
                .GPA(getGPA(sinhVien.getDanhSachHocPhan()))
                .build();
    }
    public int getIncomplete(List<HocPhan> list){
        int count = 0;
        for (HocPhan x: list) {
            if(x.getDiemThi()<4 || x.getDiemTongKet() <4) count++;
        }
        return count;
    }
    public double getGPA(List<HocPhan> list) {
        double sum = 0;
        double count = 0;
        for (HocPhan x : list) {
            if (x.getTenHocPhan().contains("Giáo dục thể chất"))
                continue;
            sum += (x.getDiemTongKet() * x.getSoTinchi());
            count += x.getSoTinchi();
        }
        sum /= count;
        sum = sum / 10 * 4;
        double result = Math.round(sum * 100.0) / 100.0;
        return result;
    }
    public int getTop(String maSinhVien, String lop){

        List<SinhVien> list = sinhVienRepository.findBylop(lop).stream().toList();
        Map<String, Double> map = new HashMap<>();
        for(SinhVien x : list){
            map.put(x.getMaSinhVien(),getGPA(x.getDanhSachHocPhan()));}
        List<Map.Entry<String, Double>> sortList = new ArrayList<>(map.entrySet());
        sortList.sort(Map.Entry.comparingByValue());
       int index=0;
        for (Map.Entry<String, Double> entry : sortList) {
            index++;
            if(entry.getKey().equals(maSinhVien)) break;
        }
        return index;
    }
}
