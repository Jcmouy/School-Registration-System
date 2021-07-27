-- Format
insert into format (id, created, period, type) values (1, CURDATE(), 'ANUAL', 'PRESENTIAL');
insert into format (id, created, period, type) values (2, CURDATE(), 'SEMESTRAL', 'ONLINE');
insert into format (id, created, period, type) values (3, CURDATE(), 'ANUAL', 'BLENDED');

-- Course

insert into course (id, created, name, date_start, date_end, formats) values (1, CURDATE(), 'Physics', '2021/02/01', '2021/11/30', '{"format": "1"}');
insert into course (id, created, name, date_start, date_end, formats) values (2, CURDATE(), 'Chemistry', '2021/02/01', '2021/07/01', '{"format": "2"}');
insert into course (id, created, name, date_start, date_end, formats) values (3, CURDATE(), 'Geography', '2021/02/01', '2021/11/30', '[{"format":"1"}, {"format":"3"}]');
insert into course (id, created, name, date_start, date_end, formats) values (4, CURDATE(), 'History', '2021/02/01', '2021/11/30', '[{"format":"1"}, {"format":"3"}]');
insert into course (id, created, name, date_start, date_end, formats) values (5, CURDATE(), 'Physical Education', '2021/02/01', '2021/07/01', '{"format": "2"}');
insert into course (id, created, name, date_start, date_end, formats) values (6, CURDATE(), 'Computer Science', '2021/02/01', '2021/07/01', '{"format": "2"}');
insert into course (id, created, name, date_start, date_end, formats) values (7, CURDATE(), 'Mathematics', '2021/02/01', '2021/11/30', '{"format": "1"}');

-- ALTER TABLE course AUTO_INCREMENT = 8;

-- Student

insert into student (id, created, code, name, last_name, date_birth, city, country) values (1, CURDATE(), 'PMLU15052005', 'Philip', 'Miller', '2005/05/15', 'Los Angeles', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (2, CURDATE(),'MDLU19032005', 'Mike', 'Davis', '2005/03/19', 'Los Angeles', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (3, CURDATE(),'JMFU15082007', 'Jane', 'Moore', '2007/08/15', 'Fresno', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (4, CURDATE(),'MGSU11112006', 'Maria', 'Gonzalez', '2006/10/11', 'San Francisco', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (5, CURDATE(),'TWLU05022008', 'Thomas', 'Wilson', '2008/02/05', 'Los Angeles', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (6, CURDATE(),'DTSU25092005', 'Diane', 'Taylor', '2005/09/25', 'San Bernardino', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (7, CURDATE(),'ATSU03122007', 'Alex', 'Thompson', '2007/12/03', 'San Francisco', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (8, CURDATE(),'JDUU21062008', 'Jodi', 'Douglas', '2008/06/21', 'Utah', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (9, CURDATE(),'ATCU03122007', 'Alex', 'Thompson', '2007/12/03', 'Connecticut', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (10, CURDATE(),'RBSU26112005', 'Richmond', 'Bishop', '2005/11/26', 'San Francisco', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (11, CURDATE(),'CFNU18092008', 'Carroll', 'Farley', '2008/09/18', 'New Jersey', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (12, CURDATE(),'EMUU21062007', 'Elvira', 'Mccall', '2007/06/21', 'Utah', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (13, CURDATE(),'MCVU22042006', 'Mcknight', 'Chase', '2006/04/22', 'Vermont', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (14, CURDATE(),'CBMU02022005', 'Cecile', 'Burks', '2005/02/02', 'Maryland', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (15, CURDATE(),'JBCU07082008', 'Janice', 'Best', '2008/08/07', 'Connecticut', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (16, CURDATE(),'SGPU15062006', 'Susan', 'Greene', '2006/06/15', 'Puerto Rico', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (17, CURDATE(),'AWOU17112007', 'Adele', 'Winters', '2007/11/17', 'Oklahoma', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (18, CURDATE(),'LMFU11052008', 'Lott', 'Mclaughlin', '2008/05/11', 'Fresno', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (19, CURDATE(),'CCWU09042007', 'Carson', 'Coleman', '2007/04/09', 'Wisconsin', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (20, CURDATE(),'DFGU02072006', 'Delores', 'Fletcher', '2006/07/02', 'Georgia', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (21, CURDATE(),'JNPU19062005', 'Jana', 'Nguyen', '2005/06/19', 'Puerto Rico', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (22, CURDATE(),'JBPU25092006', 'Johnnie', 'Byrd', '2006/09/25', 'Pennsylvania', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (23, CURDATE(),'CWNU29032006', 'Copeland', 'Wilkinson', '2006/03/29', ' New Hampshire', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (24, CURDATE(),'WCNU03032005', 'Wilma', 'Carey', '2005/03/03', 'New Jersey', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (25, CURDATE(),'FSLU04102007', 'Flossie', 'Spence', '2007/10/04', 'Los Angeles', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (26, CURDATE(),'JHWU06112007', 'Jackie', 'Head', '2007/11/06', 'Washington', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (27, CURDATE(),'RWOU09092008', 'Rosales', 'Wagner', '2008/09/09', 'Oklahoma', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (28, CURDATE(),'KRSU10082005', 'Kate', 'Rosa', '2005/08/10', 'San Francisco', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (29, CURDATE(),'SBMU18112008', 'Shelby', 'Barlow', '2008/11/18', 'Maryland', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (30, CURDATE(),'ICGU07062006', 'Ines', 'Cobb', '2006/06/07', 'Georgia', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (31, CURDATE(),'TCLU04052008', 'Tina', 'Cameron', '2008/05/04', 'Los Angeles', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (32, CURDATE(),'BPFU20082005', 'Best', 'Puckett', '2005/08/20', 'Fresno', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (33, CURDATE(),'WKWU27042006', 'Wiggins', 'Kent', '2006/04/27', 'Wisconsin', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (34, CURDATE(),'SJUU26042008', 'Sharpe', 'Johnston', '2008/04/26', 'Utah', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (35, CURDATE(),'WDPU14092006', 'Wendi', 'Dalton', '2006/09/14', 'Puerto Rico', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (36, CURDATE(),'RMNU12022007', 'Rebekah', 'Marquez', '2007/02/12', 'New Jersey', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (37, CURDATE(),'HATU03102005', 'Hollie', 'Adams', '2005/10/03', 'Texas', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (38, CURDATE(),'CMNU04082008', 'Carly', 'Monroe', '2008/08/04', 'New Jersey', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (39, CURDATE(),'DGPU19072007', 'Deborah', 'Gardner', '2007/07/19', 'Pennsylvania', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (40, CURDATE(),'HCOU21112006', 'Howell', 'Cherry', '2006/11/21', 'Oklahoma', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (41, CURDATE(),'SCVU02322006', 'Sherri', 'Chang', '2006/12/23', 'Vermont', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (42, CURDATE(),'GPNU28102005', 'Gail', 'Pena', '2005/10/28', ' New Hampshire', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (43, CURDATE(),'SPGU26022008', 'Stewart', 'Preston', '2008/02/26', 'Georgia', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (44, CURDATE(),'PMWU01032005', 'Powers', 'Mckenzie', '2005/03/01', 'Washington', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (45, CURDATE(),'BMMU09072007', 'Barlow', 'Mendoza', '2007/07/09', 'Minnesota', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (46, CURDATE(),'DPIU12032006', 'Dyer', 'Perez', '2006/03/12', 'Idaho', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (47, CURDATE(),'CCMU13112007', 'Christian', 'Cardenas', '2007/11/13', 'Maryland', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (48, CURDATE(),'HBPU22102007', 'Hughes', 'Bennett', '2007/10/22', 'Pennsylvania', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (49, CURDATE(),'TFNU27062008', 'Teri', 'French', '2008/06/27', 'New Mexico', 'USA');
insert into student (id, created, code, name, last_name, date_birth, city, country) values (50, CURDATE(),'CBCU02092005', 'Conrad', 'Baird', '2005/09/02', 'Connecticut', 'USA');


-- ALTER SEQUENCE student_id_seq RES


-- Course Format

insert into course_format ( id, created, course_id, format_id ) values ( 1, CURDATE(), 1, 1);
insert into course_format ( id, created, course_id, format_id ) values ( 2, CURDATE(), 2, 2);
insert into course_format ( id, created, course_id, format_id ) values ( 3, CURDATE(), 3, 1);
insert into course_format ( id, created, course_id, format_id ) values ( 4, CURDATE(), 3, 3);
insert into course_format ( id, created, course_id, format_id ) values ( 5, CURDATE(), 4, 1);
insert into course_format ( id, created, course_id, format_id ) values ( 6, CURDATE(), 4, 3);
insert into course_format ( id, created, course_id, format_id ) values ( 7, CURDATE(), 5, 2);
insert into course_format ( id, created, course_id, format_id ) values ( 8, CURDATE(), 6, 2);
insert into course_format ( id, created, course_id, format_id ) values ( 9, CURDATE(), 7, 1);


-- ALTER SEQUENCE course_format_id_seq RESTART WITH 10;
