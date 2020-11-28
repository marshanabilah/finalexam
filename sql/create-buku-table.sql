create table buku (
 id  int(3) NOT NULL AUTO_INCREMENT,
 judul varchar(120) NOT NULL,
 penulis varchar(220) NOT NULL,
 penerbit varchar(120) NOT NULL,
 tahun_terbit int(3) NOT NULL,
 kategori varchar(120) NOT NULL,
 PRIMARY KEY (id)
);