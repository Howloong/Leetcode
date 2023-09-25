#leetcode
submit region
begin
    (Prohibit modification and deletion)
    # Write your MySQL query statement below
select patient_id, patient_name, conditions
from Patients
where conditions like '% DIAB1%'
   or conditions like 'DIAB1%' #leetcode submit region
end
    (Prohibit modification and deletion)
