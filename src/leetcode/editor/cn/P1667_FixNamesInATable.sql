#leetcode submit region begin(Prohibit modification and deletion)
# Write your MySQL query statement below
select user_id, concat(upper(left(name, 1)), lower(right(name, length(name) - 1))) as name
from Users
order by user_id
#leetcode submit region end(Prohibit modification and deletion)
