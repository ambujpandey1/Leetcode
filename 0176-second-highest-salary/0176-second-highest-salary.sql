# Write your MySQL query statement below
-- SELECT MAX(salary) AS SecondHighestSalary 
-- FROM Employee 
-- WHERE salary < (SELECT MAX(salary) FROM Employee);

-- Select salary as SecondHighestSalary from employee 
-- order by salary desc
-- limit 1 offset 1

select 
    COALESCE((
        Select distinct  salary  from employee 
order by salary desc
limit 1 offset 1
    ),null) as SecondHighestSalary
