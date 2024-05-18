drop database if exists magic_items_test;

create database magic_items_test;

use magic_items_test;

create table t_items(
nombre varchar(100) not null,
tipo enum("Normal Item", "Conjured", "Aged Brie", "Backstage Passes", "Sulfuras") not null default "Normal Item",
quality int not null,
sell_in int not null,
primary key(nombre)
) ENGINE InnoDB;

create TABLE t_magos(
nombre varchar(100) not null,
primary key(nombre)
) ENGINE InnoDB;

create TABLE t_encargos(
codigo int unsigned auto_increment not null,
item varchar(100) not null,
mago varchar (100) not null,
primary key (codigo),
foreign key (item) references t_items(nombre)
	on delete cascade
    on update cascade,
index item_encargado(item),
foreign key (mago) references t_magos(nombre)
	on delete cascade
    on update cascade,
index mago_encarga(mago),
unique index mago_item (mago,item)
) Engine InnoDB;

insert into t_items
(nombre, quality, sell_in)
values ("Arroz", 10, 3),
		("Pasta", 4, 10);
        
insert into t_magos
(nombre)
values ("Hermione"),
		("Harry Potter");
        
insert into t_encargos
(item, mago)
values ("Arroz","Hermione"),
		("Pasta","Hermione");
        
select *  from magic_items_test.t_encargos;