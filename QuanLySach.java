
import java.util.ArrayList;
import java.util.List;

public class QuanLySach {
    private List<Sach> danhSach;

    public QuanLySach() {
        danhSach = new ArrayList<>();
    }

    public void them(Sach s) {
        danhSach.add(s);
    }

    public boolean xoaTheoMa(String maSach) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaSach().equals(maSach)) {
                danhSach.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean capNhat(String maSach, Sach sachMoi) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaSach().equals(maSach)) {
                danhSach.set(i, sachMoi);
                return true;
            }
        }
        return false;
    }

    public Sach timTheoMa(String maSach) {
        for (Sach s : danhSach) {
            if (s.getMaSach().equals(maSach)) {
                return s;
            }
        }
        return null;
    }

    public void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách đang rỗng.");
            return;
        }
        for (Sach s : danhSach) {
           // Ưu tiên toString nếu lớp con ghi đè nó; nếu không thì dùng hienThiThongTin cho lớp cơ sở
            System.out.println(s.toString());
            try {
                System.out.println("Giá Bán Ước Tính: " + String.format("%.0f", s.tinhGiaBan()) + " VNĐ");
            } catch (AbstractMethodError ame) {
                // không nên xảy ra vì Sach là lớp trừu tượng và các lớp con triển khai phương thức tinhGiaBan
            }
        }
    }
}
