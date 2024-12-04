package nguyenvanphuc.KMAJourey.controller;

import lombok.extern.slf4j.Slf4j;
import nguyenvanphuc.KMAJourey.dto.SinhVienResponse;
import nguyenvanphuc.KMAJourey.entity.SinhVien;
import nguyenvanphuc.KMAJourey.exception.AppException;
import nguyenvanphuc.KMAJourey.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller

public class SinhVienController {
    @Autowired
    private SinhVienService sinhVienService;
    private SinhVienResponse sinhVienResponse;
    @PostMapping("/sv")
    public String getSinhVienRepository(@RequestParam("masv") String maSinhVien, Model model) {
        try {
            sinhVienResponse = sinhVienService.getSinhVien(maSinhVien);
            model.addAttribute("sv",sinhVienResponse);
        } catch (AppException e) {
            model.addAttribute("error",e.getErrorCode().getMessage());
        }
        return "home";
    }




}
