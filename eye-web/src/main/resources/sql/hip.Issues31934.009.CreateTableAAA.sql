-- =========================================================
-- hip.Issues31934.005.AddColumnStatusForTableExample.sql
-- Here is description about this sql
-- XXX 10/20/2014
-- =========================================================

declare
        applyScriptReturnCode NUMBER(1);
        scriptName VARCHAR2(256); -- PUT YOUR REAL SCRIPT NAME HERE!
        release  VARCHAR2(256);-- PUT THE RELEASE HERE
        milestone  VARCHAR2(256);-- PUT MILESTONE HERE
        allowMultipleRuns NUMBER(1);-- USE 1 IF THIS SCRIPT CAN BE RUN MORE THAN ONCE
		tableNums NUMBER(2);

BEGIN
	scriptName:='hip.Issues31934.009.CreateTableAAA.sql';-- PUT YOUR REAL SCRIPT NAME HERE!
	release:='1410';-- PUT THE RELEASE HERE
	milestone:='1';-- PUT MILESTONE HERE
	allowMultipleRuns:=0;-- USE 1 IF THIS SCRIPT CAN BE RUN MORE THAN ONCE
    ApplyScript(scriptName=>scriptName,release=>release,milestone=>milestone,allowMultipleRuns=>allowMultipleRuns,returnCode=>applyScriptReturnCode);
	IF applyScriptReturnCode<>0 THEN
		DBMS_OUTPUT.PUT_LINE('OCCUR ERROR!');
		ROLLBACK;
		RETURN;
	END IF;

select count(*) INTO tableNums from user_tables  where table_name = 'REP_LOGS1';
IF tableNums <> 0 THEN
		DBMS_OUTPUT.PUT_LINE('DB Existed!');
		ROLLBACK;
		RETURN;
END IF;
execute immediate 'create table REP_LOGS1 ( log_s_no NUMBER not null, log_date DATE default sysdate not null, log_type VARCHAR2(1) DEFAULT ''E'' not null, log_node VARCHAR2(60) not null, log_mesg VARCHAR2(300) not null )';
execute immediate 'comment on table REP_LOGS1 is ''系统操作日志信息表''';
execute immediate 'comment on column REP_LOGS1.log_s_no is ''日志序列号 由序列SEQ_REP_LOGS生成''';

END;
