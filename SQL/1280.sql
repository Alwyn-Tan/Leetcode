SELECT stu.student_id, stu.student_name, sub.subject_name, ifnull(count(exa.subject_name),0) AS attended_exams
FROM Students stu CROSS JOIN Subjects sub LEFT JOIN Examinations exa using(student_id, subject_name)
GROUP BY stu.student_id, sub.subject_name
ORDER BY stu.student_id, sub.subject_name