package nguyenvanphuc.KMAJourey.exception;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)

public enum ErrorCode {
    SV_NOT_EXIT("Sinh viên không tồn tại");


    String message;
    ErrorCode(String message) {
        this.message = message;
    }
}
