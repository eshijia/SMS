BEGIN  
#declare variable
declare total int default 0;
declare done int;
declare tmp_score int;

#declare cursor
DECLARE cur1 CURSOR FOR SELECT st_score FROM tb_score_record as sr, tb_score_type as st WHERE sr.sr_score_type_id = st.st_id and sr.sr_student_id = in_sr_stu_id;

#declare handle 
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

#open cursor
OPEN cur1;

#starts the loop
the_loop: LOOP

FETCH cur1 INTO tmp_score;

IF done THEN
      LEAVE the_loop;
END IF;

set total = total + tmp_score;  

END LOOP the_loop;
CLOSE cur1;

insert into tb_score_record_total values(in_sr_id,total);
END