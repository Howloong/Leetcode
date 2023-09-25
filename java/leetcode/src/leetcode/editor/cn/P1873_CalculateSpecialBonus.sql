#leetcode
submit region
begin
    (Prohibit modification and deletion)
    # Write your MySQL query statement below
/*select employee_id,salary as bonus from Employees
where employee_id%2=1 and name not like 'M%'
union
select employee_id,salary*0 as bonus from Employees
where employee_id%2=0 or name  like 'M%'
order by employee_id*/
select employee_id,
       if(employee_id % 2 = 1 and name not like 'M%', salary, 0) as bonus
from Employees
order by employee_id #leetcode submit region
end
    (Prohibit modification and deletion)
