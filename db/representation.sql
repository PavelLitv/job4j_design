create view show_students_with_2_or_more_books_by_asc as
select s.name as student, count(a.name), a.name as author
from students as s
         join orders o on s.id = o.student_id
         join books b on o.book_id = b.id
         join authors a on b.author_id = a.id
group by (s.name, a.name)
having count(a.name) >= 2
order by s.name
limit 10;

alter view show_students_with_2_or_more_books_by_asc rename to
    show_students_with_2_or_more_books_by_asc_lim_10;

select student
from show_students_with_2_or_more_books_by_asc_lim_10;
