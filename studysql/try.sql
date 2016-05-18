select s.sno,s.sname from student as s,
(select sno,score from sc where cno = 1 ) as a,
(select sno,score from sc where cno = 2 ) as b
where s.sno = a.sno and a.sno = b.sno and a.score > b.score;

select sno,avg(score) as avg from sc group by sc.sno having avg > 60;

select s.sno,s.sname,count(sc.sno),sum(sc.score)from student as s join sc on s.sno = sc.sno group by s.sno,s.sname ;

select count(distinct(tname)) from teacher where tname like '李%';

select s.sname from student as s where s.sno not in(
select distinct(sc.sno) from sc,course as c,teacher as t where sc.cno = c.cno and c.tno = t.tno and t.tname = '叶平');