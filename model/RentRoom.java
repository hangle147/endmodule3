package model;

public class RentRoom {
    private int id;
    private String tenNguoiThue;
    private String soDienThoai;
    private String ngayBatDau;
    private int idHinhThucThanhToan;
    private String tenLoaiThanhToan;
    private String ghiChu;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTenNguoiThue() { return tenNguoiThue; }
    public void setTenNguoiThue(String tenNguoiThue) { this.tenNguoiThue = tenNguoiThue; }

    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }

    public String getNgayBatDau() { return ngayBatDau; }
    public void setNgayBatDau(String ngayBatDau) { this.ngayBatDau = ngayBatDau; }

    public int getIdHinhThucThanhToan() { return idHinhThucThanhToan; }
    public void setIdHinhThucThanhToan(int idHinhThucThanhToan) { this.idHinhThucThanhToan = idHinhThucThanhToan; }

    public String getTenLoaiThanhToan() { return tenLoaiThanhToan; }
    public void setTenLoaiThanhToan(String tenLoaiThanhToan) { this.tenLoaiThanhToan = tenLoaiThanhToan; }

    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }
}
