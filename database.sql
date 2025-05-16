CREATE TABLE loai_thanh_toan (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ten_loai VARCHAR(20) NOT NULL UNIQUE
);
INSERT IGNORE INTO loai_thanh_toan (ten_loai)
VALUES 
  ('Theo tháng'), 
  ('Theo quý'), 
  ('Theo năm');

CREATE TABLE thue_phong (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ten_nguoi_thue VARCHAR(50) NOT NULL,
    so_dien_thoai VARCHAR(15) NOT NULL,
    ngay_bat_dau DATE NOT NULL,
    id_hinh_thuc_thanh_toan INT NOT NULL,
    ghi_chu VARCHAR(200),
    FOREIGN KEY (id_hinh_thuc_thanh_toan) REFERENCES loai_thanh_toan(id)
);

SELECT * FROM loai_thanh_toan;
select * from thue_phong;