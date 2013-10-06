delimiter //
CREATE TRIGGER tri_score_record after insert ON tb_score_record
FOR EACH ROW
BEGIN
call sp_accumulate_score(NEW.sr_id, NEW.sr_student_id);
END
//