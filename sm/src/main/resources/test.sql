insert into tb_score_type values (1, 'ppt', 5);
insert into tb_score_type values (2, '顶', 1);

insert into tb_score_record values (null, 1, 1, 'nothing comment', null);
insert into tb_score_record values (null, 1, 2, 'nothing comment', null);


select * from tb_score_record as sr, tb_score_type as st where sr.sr_score_type_id = st.st_id and sr.sr_student_id = 1 order by sr.sr_ct desc;