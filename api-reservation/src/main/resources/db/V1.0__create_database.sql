create table contact (id bigint auto_increment, email varchar(50) not null, telephone varchar(50) not null, primary key (id)) engine=InnoDB;

create table document (id bigint auto_increment, expiration date not null, number varchar(20) not null, type varchar(255) not null, primary key (id)) engine=InnoDB;

create table passenger (id bigint auto_increment, birth date not null, first_name varchar(20) not null, gender varchar(255) not null, last_name varchar(20) not null, nationality varchar(3) not null, type varchar(255) not null, document_id bigint, primary key (id)) engine=InnoDB;

create table reservation (id bigint auto_increment, itinerary_id varchar(50) not null, contact_id bigint, primary key (id)) engine=InnoDB;

create table reservation_passengers (reservation_id bigint not null, passengers_id bigint not null) engine=InnoDB;

create table hibernate_sequence (next_val bigint) engine=InnoDB;


alter table reservation_passengers add constraint UK_5iytn6vcvt4kq77l3phxnrt0j unique (passengers_id);

alter table passenger add constraint FKm35atcam8mpm9panp4e6s0wyl foreign key (document_id) references document (id);

alter table reservation add constraint FKh9qekoawefvwtaipfabwd19uf foreign key (contact_id) references contact (id);

alter table reservation_passengers add constraint FK3xmncvouorbe4uq56fy53jbs2 foreign key (passengers_id) references passenger (id);

alter table reservation_passengers add constraint FK8m7x25gfi0muq3p8y11lvtdr3 foreign key (reservation_id) references reservation (id);