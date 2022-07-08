#leetcode submit region begin(Prohibit modification and deletion)
# Write your MySQL query statement below
select sell_date,
       count(distinct product) as num_sold,
        group_concat(distinct product order by product separator ',') as products
from Activities
group by sell_date
order by sell_date
#leetcode submit region end(Prohibit modification and deletion)
