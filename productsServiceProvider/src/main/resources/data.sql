CREATE TABLE world.`product` (
                                 `id` int(11),
                                 `productName` varchar(256) DEFAULT NULL,
                                 `price` int(11) DEFAULT NULL

);

insert into world.`product` values(1,"book1",2000.00);
insert into world.`product` values(2,"book2",2000.00);
insert into world.`product` values(3,"book3",2000.00);
insert into world.`product` values(4,"book4",2000.00);
insert into world.`product` values(5,"book5",2000.00);
insert into world.`product` values(6,"book6",2000.00);
insert into world.`product` values(7,"book7",2000.00);
insert into world.`product` values(8,"book8",2000.00);
insert into world.`product` values(9,"book9",2000.00);
insert into world.`product` values(10,"book10",2000.00);
insert into world.`product` values(11,"book11",2000.00);

select *from world.product;