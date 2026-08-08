# Write your MySQL query statement below
--  select user_id , name , mail from users where  mail  regexp '^[a-zA-Z][a-zA-Z0-9_\.\-]*@leetcode\.com$' and right(mail ,  13) like '%@leetcode.com';
SELECT 
    user_id, 
    name, 
    mail
FROM 
    users
WHERE 
    mail REGEXP '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode\\.com$' 
    AND mail LIKE BINARY '%@leetcode.com';
