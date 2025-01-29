SELECT customer_id, count(customer_id) AS count_no_trans
FROM visits LEFT JOIN Transactions USING(visit_id)
WHERE transaction_id IS null
GROUP BY customer_id
