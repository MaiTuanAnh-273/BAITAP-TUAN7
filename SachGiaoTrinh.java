
public class SachGiaoTrinh extends Sach implements IKiemKe {
    private String monHoc;
    private String capDo;

    public SachGiaoTrinh(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong,
                         String monHoc, String capDo, double giaCoBan) {
        super(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan);
        this.monHoc = monHoc;
        this.capDo = capDo;
    }

    public String getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
    }

    public String getCapDo() {
        return capDo;
    }

    public void setCapDo(String capDo) {
        this.capDo = capDo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mã sách: ").append(getMaSach()).append(System.lineSeparator());
        sb.append("Tiêu đề: ").append(getTieuDe()).append(System.lineSeparator());
        sb.append("Tác giả: ").append(getTacGia()).append(System.lineSeparator());
        sb.append("Năm xuất bản: ").append(getNamXuatBan()).append(System.lineSeparator());
        sb.append("Số lượng: ").append(getSoLuong()).append(System.lineSeparator());
        sb.append("Giá bán ước tính: ").append(String.format("%.0f", tinhGiaBan())).append(" VNĐ").append(System.lineSeparator());
        sb.append("Môn học: ").append(monHoc).append(System.lineSeparator());
        sb.append("Cấp độ: ").append(capDo).append(System.lineSeparator());
        sb.append("-------------------------");
        return sb.toString();
    }

    @Override
    public double tinhGiaBan() {
        int namHienTai = 2025;
        int soNam = namHienTai - getNamXuatBan();
        if (soNam < 0) soNam = 0;
        return getGiaCoBan() + (soNam * 5000);
    }

    @Override
    public boolean kiemTraTonKho(int soLuongToiThieu) {
        return getSoLuong() >= soLuongToiThieu;
    }

    @Override
    public void capNhatViTri(String viTriMoi) {
        System.out.println("Đã chuyển sách " + getTieuDe() + " đến khu vực: " + viTriMoi + ".");
    }
}
