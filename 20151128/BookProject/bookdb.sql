create table language (
  id number primary key,
  name varchar2(50) not null,
  status char(1) default 'd' not null 
)
/

select * from language
where status = 'a'
/

insert into language values(1, 'English', 'a')
/

insert into language values(2, 'Azerbaijan', 'a')
/

insert into language values(3, 'Russian', 'a')
/
insert into language values(4, 'Turkish', 'a')
/

create table genre(
  id number primary key,
  name varchar2(100) not null,
  status char(1) default 'd' not null 
)
/

select * from genre
/

insert into genre values(1, 'Comedy', 'a')
/

insert into genre values(2, 'Triller', 'a')
/

insert into genre values(3, 'Action', 'a')
/

create table author(
  id number primary key,
  name varchar2(300) not null,
  surname varchar2(300) not null,
  email varchar2(100) not null,
  about varchar2(1000) not null,
  status char(1) default 'd' not null
)
/

select * from author
/

CREATE SEQUENCE SEQ_AUTHOR_ID 
INCREMENT BY 1 
START WITH 1 
MINVALUE 1 
CACHE 20
/

select seq_author_id.nextval from dual
/

insert into author values(seq_author_id.nextval, 'Orhan', 'Pamuk', 'orhan@pamuk.net', 'Nobel prize winner from Turkey', 'a')
/

select * from author
/

create table publisher(
  id number primary key,
  name varchar2(100) not null,
  address varchar2(500) not null,
  email varchar2(100) not null,
  status char(1) default 'd' not null
)
/

select * from publisher
/

CREATE SEQUENCE SEQ_PUBLISHER_ID 
INCREMENT BY 1 
START WITH 1 
MINVALUE 1 
CACHE 20
/

insert into publisher values(seq_publisher_id.nextval, 
  'O''Reilly', 
  '1005 Gravenstein Hwy N Sebastopol, CA 95472', 
  'orders@oreilly.com', 'a')
/

insert into publisher values(seq_publisher_id.nextval, 
  'Nil', 
  'Istanbul, Kadikoy', 
  'noreply@nil.com.tr', 'a')
/

select * from publisher
/

create table book(
  id number primary key,
  isbn varchar2(13) not null,
  title varchar2(200) not null,
  description varchar2(1000) not null,
  rating number(1) default 0.0 not null ,
  genre number not null,
  price number default 0.0,
  cover varchar2(1000) not null,
  page_count number default 0 not null,
  publisher_id number not null,
  publish_date date not null,
  language number not null,
  status char(1) default 'd' not null
)
/

select * from book
/
FK
language
publisher_id
genre
/

create table book_author(
  id number primary key,
  book_id number not null,
  author_id number not null,
  status char(1) default 'd' not null,
  constraint fk_book_id foreign key(book_id) references book(id) on delete set null,
  constraint fk_author_id foreign key(author_id) references author(id) on delete set null
)
/

drop table book_author
/

select id, name, address, email 
from publisher
where status = 'a'
/

CREATE SEQUENCE SEQ_BOOK_ID 
INCREMENT BY 1 
START WITH 1 
MINVALUE 1 
CACHE 20
/

select * from book
/

insert into book(id, 
  isbn, 
  title,
  description,
  rating,
  genre,
  price,
  cover,
  page_count,
  publisher_id,
  publish_date,
  language, 
  status) 
  values(seq_book_id.nextval, 
  '9750504822', 
  'MY FATHER''S SUITCASE', 
  'Two years before his death, my father gave me a small suitcase full of his writings, hand writings and notebooks',
  4.2,
  4,
  26,
  'E:\\JavaWeb\\books\\babaminbavulu.jpg',
  93,
  3,
  sysdate, --to_date('dd-mon-yyyy', '07-FEB-2006'),
  4,
  'a'
  )
/

select to_date('dd-mon-yyyy', '07-FEB-2006') dt, sysdate from dual
/

select * from book
/

insert into genre values(4, 'Drama', 'a')
/

select * from publisher
/

FK
language
publisher_id
genre
/

alter table book
add constraint fk_language foreign key(language) references language(id) on delete set null
/

alter table book
add constraint fk_publisher foreign key(publisher_id) references publisher(id) on delete set null
/

alter table book
add constraint fk_genre foreign key(genre) references genre(id) on delete set null
/

select b.id book_id, 
  a.id author_id,
  a.name author_name,
  a.surname author_surname,
  b.isbn, b.title, 
  b.rating,
  b.genre genre_id,
  g.name genre_name,
  b.price, 
  b.cover,
  b.page_count,
  b.publish_date,
  b.language language_id,
  lg.name language_name,  
  b.description,
  p.id publisher_id, p.name publisher_name
from book b join publisher p on b.publisher_id = p.id 
  and b.status = 'a' and p.status = 'a'
  join genre g on b.genre = g.id and g.status = 'a'
  join language lg on b.language = lg.id and lg.status = 'a'
  join book_author ba on b.id = ba.book_id and ba.status = 'a'
  join author a on ba.author_id = a.id and a.status = 'a'
where p.id = 7
/

select * from author
/

insert into book_author values(1, 4,7, 'a')
/
