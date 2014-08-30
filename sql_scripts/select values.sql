use db5;

select PERMISSION_ID into @pid from permissions where ROLE="ROLE_USER";
select GROUP_ID into @grid from groups where GROUP_NAME="USER";

insert into group_permission values(@grid, @pid);

select PERMISSION_ID into @pid from permissions where ROLE="ROLE_ADMIN";
select GROUP_ID into @grid from groups where GROUP_NAME="ADMIN";

insert into group_permission values(@grid, @pid);

select PARTICIPANT_ID into @partid from participants where PART_NAME="Bob";

insert into user_info (`PARTICIPANT_ID`, `LOGIN`, `USER_PASSWORD`, `ACCOUNT_NOT_EXPIRED`, `ACCOUNT_NOT_BLOCKED`, 
	`CREDENTIALS_NOT_EXPIRED`, `ENABLED`) values(@partid, "bob", "$2a$10$FkpLaNm/BlQ/g67OdD.lf.Zqk.Qt/pBqxpzyXbgAdCitbGGZTROXC",
	true, true, true, true);

select PARTICIPANT_ID into @partid from participants where PART_NAME="Jimi";

insert into user_info (`PARTICIPANT_ID`, `LOGIN`, `USER_PASSWORD`, `ACCOUNT_NOT_EXPIRED`, `ACCOUNT_NOT_BLOCKED`, 
	`CREDENTIALS_NOT_EXPIRED`, `ENABLED`) values(@partid, "jimi", "$2a$10$uAryrywbESAQEno17uaO3e4Q61IFX2s6VH033Lz4kHr0crDiCah.y",
	true, true, true, true);

select GROUP_ID into @grid from groups where GROUP_NAME="USER";
select USER_ID into @userid from user_info where LOGIN="bob";
insert into user_group (`USER_ID`, `GROUP_ID`) values(@userid, @grid);
select USER_ID into @userid from user_info where LOGIN="jimi";
insert into user_group (`USER_ID`, `GROUP_ID`) values(@userid, @grid);