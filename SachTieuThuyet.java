
public class SachTieuThuyet extends Sach implements IKiemKe {
    private String theLoai;
    private boolean laSachSeries;

    public SachTieuThuyet(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong,
                           String theLoai, boolean laSachSeries, double giaCoBan) {
        super(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan);
        this.theLoai = theLoai;
        this.laSachSeries = laSachSeries;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public boolean isLaSachSeries() {
        return laSachSeries;
    }

    public void setLaSachSeries(boolean laSachSeries) {
        this.laSachSeries = laSachSeries;
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
        sb.append("Thể loại: ").append(theLoai).append(System.lineSeparator());
        sb.append("Thuộc series: ").append(laSachSeries ? "Có" : "Không").append(System.lineSeparator());
        sb.append("-------------------------");
        return sb.toString();
    }

    @Override
    public double tinhGiaBan() {
        double extra = laSachSeries ? 15000 : 0;
        return getGiaCoBan() + extra;
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
