2013/10/10 数据库更新
alter table tb_score_record add sr_score_type_score int;

update tb_score_record as sr, tb_score_type as st
set sr.sr_score_type_score = st.st_score
where sr.sr_score_type_id = st.st_id;

2013/10/14 数据库更新
alter table tb_score_record add sr_score_type_name varchar(40);

update tb_score_record as sr, tb_score_type as st
set sr.sr_score_type_name = st.st_name
where sr.sr_score_type_id = st.st_id;

alter table tb_score_record add sr_student_name varchar(10);

update tb_score_record as sr, tb_student as stu
set sr.sr_student_name = stu.stu_name
where sr.sr_student_id = stu.stu_id;

alter table tb_info modify column if_info varchar(2000);

