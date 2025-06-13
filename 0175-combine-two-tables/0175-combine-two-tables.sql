# Write your MySQL query statement below
select  p.firstname as firstName ,p.lastname as lastName,a.city,a.state
from Person p left join Address a  on
p.personId = a.personId;