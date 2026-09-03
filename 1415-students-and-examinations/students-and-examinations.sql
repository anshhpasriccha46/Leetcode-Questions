SELECT 
    a.student_id,
    a.student_name,
    c.subject_name,
    COUNT(b.subject_name) AS attended_exams
FROM students a
CROSS JOIN subjects c
LEFT JOIN examinations b
    ON a.student_id = b.student_id
    AND c.subject_name = b.subject_name
GROUP BY 
    a.student_id,
    a.student_name,
    c.subject_name
ORDER BY 
    a.student_id,
    c.subject_name;