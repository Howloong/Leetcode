#leetcode
submit region
begin
    (Prohibit modification and deletion)
    # Write your MySQL query statement below
select u.name, sum(t.amount) as balance
from Transactions as t
         left join Users as u
                   on u.account = t.account
group by t.account
having balance >= 10000 #leetcode submit region
end
    (Prohibit modification and deletion)
