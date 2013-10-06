insert into tb_score_type values (1, '初始化', 0);
insert into tb_score_type values (2, 'ppt', 5);
insert into tb_score_type values (3, '顶', 1);
insert into tb_score_type values (4, '课程寄语', 1);

insert into tb_score_record values (null, 1, 1, 'init', null);
insert into tb_score_record values (null, 2, 1, 'init', null);
insert into tb_score_record values (null, 3, 1, 'init', null);
insert into tb_score_record values (null, 4, 1, 'init', null);
insert into tb_score_record values (null, 5, 1, 'init', null);
insert into tb_score_record values (null, 6, 1, 'init', null);
insert into tb_score_record values (null, 7, 1, 'init', null);
insert into tb_score_record values (null, 8, 1, 'init', null);
insert into tb_score_record values (null, 9, 1, 'init', null);
insert into tb_score_record values (null, 10, 1, 'init', null);
insert into tb_score_record values (null, 11, 1, 'init', null);
insert into tb_score_record values (null, 12, 1, 'init', null);
insert into tb_score_record values (null, 13, 1, 'init', null);
insert into tb_score_record values (null, 14, 1, 'init', null);
insert into tb_score_record values (null, 15, 1, 'init', null);
insert into tb_score_record values (null, 16, 1, 'init', null);
insert into tb_score_record values (null, 17, 1, 'init', null);
insert into tb_score_record values (null, 18, 1, 'init', null);
insert into tb_score_record values (null, 19, 1, 'init', null);
insert into tb_score_record values (null, 20, 1, 'init', null);
insert into tb_score_record values (null, 21, 1, 'init', null);
insert into tb_score_record values (null, 22, 1, 'init', null);
insert into tb_score_record values (null, 23, 1, 'init', null);
insert into tb_score_record values (null, 24, 1, 'init', null);

select * from tb_score_record as sr, tb_score_record_total as srt, tb_student as stu, tb_score_type as st where sr.sr_student_id = stu.stu_id and sr.sr_score_type_id = st.st_id and srt.srt_id = sr.sr_id
select * from tb_score_record as sr, tb_score_type as st where sr.sr_score_type_id = st.st_id and sr.sr_student_id = 1 order by sr.sr_ct desc;
select * from tb_score_record as sr, tb_student as stu, tb_score_type as st where sr.sr_student_id = stu.stu_id and sr.sr_score_type_id = st.st_id

int sr_id = rs.getInt("sr_id");
				String stu_no = rs.getString("stu_no");
				String stu_name = rs.getString("stu_name");
				String sr_ct = rs.getString("sr_ct");
				String st_name = rs.getString("st_name");
				int st_score = rs.getInt("st_score");
				int srt_score = rs.getInt("srt_score");

select max(srt_score), sr_id, stu_no, stu_name, sr_ct, st_name, st_score, srt_score from (
select * from tb_score_record as sr, tb_score_record_total as srt, tb_student as stu, tb_score_type as st where sr.sr_student_id = stu.stu_id and sr.sr_score_type_id = st.st_id and srt.srt_id = sr.sr_id order by sr_id desc
) as temp group by stu_no;
