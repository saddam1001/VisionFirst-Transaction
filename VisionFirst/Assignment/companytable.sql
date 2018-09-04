create table companytable (sno number GENERATED ALWAYS AS IDENTITY PRIMARY KEY, company_name varchar2(30), company_address varchar2(30), created_by varchar2(15), actions varchar2(10));
insert into companytable(company_name, company_address, created_by, actions) values('company1', 'meerut', 'Saddam', 'approved');
insert into companytable(company_name, company_address, created_by, actions) values('company2', 'noida', 'User', '');
insert into companytable(company_name, company_address, created_by, actions) values('company3', 'delhi', 'User', '');