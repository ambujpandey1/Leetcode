# Write your MySQL query statement below
(select u.name as results      
from Users u
left join MovieRating m
on u.user_id =m.user_id 
group by u.user_id         
order by count(m.user_id) desc ,u.name
limit 1)
union all
(select k.title as results      
from Movies  k
left join MovieRating m
on k.movie_id =m.movie_id 
where extract(year_month from created_at) =202002
group by k.movie_id         
order by avg(m.rating) desc ,k.title
limit 1)
