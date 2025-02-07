# Write your MySQL query statement below
SELECT contest_id, round(100 * count(user_id) /( SELECT count(*) from users), 2)AS percentage 
FROM register
GROUP BY contest_id
ORDER BY percentage desc, contest_id
