-- we don't know how to generate schema dbappdev (class Schema) :(
create table bankaccount
(
	customerid varchar(128) not null,
	accountid int(30) not null
)
;

create table cart
(
	customerid varchar(128) not null,
	itemid int not null,
	itemcount int not null
)
;

create table item
(
	itemid int not null,
	price int not null,
	itemName varchar(128) not null,
	constraint Item_itemid_uindex
		unique (itemid)
)
;

alter table item
	add primary key (itemid)
;

create table user
(
	customerid varchar(128) not null,
	userid varchar(128) not null,
	password varchar(128) null,
	constraint User_customerid_uindex
		unique (customerid),
	constraint User_password_uindex
		unique (password),
	constraint User_userid_uindex
		unique (userid)
)
;

alter table user
	add primary key (customerid)
;

