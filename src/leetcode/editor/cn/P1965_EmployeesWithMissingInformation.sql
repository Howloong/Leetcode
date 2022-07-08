#leetcode submit region begin(Prohibit modification and deletion)
# Write your MySQL query statement below
select A.employee_id
from Employees as A
         left join Salaries as B on A.employee_id = B.employee_id
where B.salary is null
union
select A.employee_id
from Salaries as A
         left join Employees as B on A.employee_id = B.employee_id
where B.name is null
order by employee_id
#leetcode submit region end(Prohibit modification and deletion)
