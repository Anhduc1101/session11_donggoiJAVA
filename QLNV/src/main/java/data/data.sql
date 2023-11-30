create database session11;
use session11;

create table employee
(
    id       int auto_increment primary key not null,
    name     varchar(255)                   not null,
    phone    varchar(255)                   not null,
    address  varchar(255)                   not null,
    birthday date                           not null,
    gender   bit(1)                         not null,
    salary   int                            not null
);

delimiter //
create procedure proc_show_employee()
begin
    select * from employee;
end //

delimiter //
create procedure proc_add_employee(in eName varchar(255), ePhone varchar(255), eAddress varchar(255), eBirthday date,
                                   eGender bit(1), eSalary int)
begin
    insert into employee(name, phone, address, birthday, gender, salary)
    values (name = eName, phone = ePhone,
            address = eAddress,
            birthday = eBirthday, gender = eGender,
            salary = eSalary);
end
//

delimiter //
create procedure proc_edit_employee(in e_name varchar(255), e_phone varchar(255), e_address varchar(255),
                                    e_birthday date, e_gender bit(1), e_salary varchar(255), e_id int)
begin
    update employee
    set name     = e_name,
        phone    = e_phone,
        address  = e_address,
        birthday = e_birthday,
        gender   = e_gender,
        salary   = e_salary
    where id = e_id;
end //

delimiter //
create procedure proc_delete_employee(in eId int)
begin
    delete from employee where id = eId;
end //

delimiter //
create procedure proc_find_employee_by_name(in eName varchar(255))
begin
    select * from employee where name like concat('%',eName,'%');
end //

delimiter //
create procedure proc_find_employee_by_id(in eId int)
begin
    select * from employee where id=eId;
end //

delimiter //
create procedure proc_pagination(in _limit int, noPage int,out total int)
begin
    declare  _offset int;
    set _offset=(noPage-1)*_limit;
    set total=ceil((select count(*)from employee)/_limit);
    select *from employee limit _limit offset _offset;

end //

