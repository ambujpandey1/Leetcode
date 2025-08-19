-- select * 
-- from Users
-- where mail REGEXP '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode[.]com$'

-- MySQL 8.0+ (recommended)
SELECT user_id, name, mail
FROM Users
WHERE REGEXP_LIKE(mail, '^[A-Za-z][A-Za-z0-9_.-]*@leetcode[.]com$', 'c');



-- SELECT user_id, name, mail
-- FROM Users
-- WHERE mail REGEXP '^[a-zA-Z][a-zA-Z0-9._-]*@leetcode\\.com$';


-- SELECT user_id, name, mail
-- FROM Users
-- WHERE mail REGEXP '^[a-zA-Z][a-zA-Z0-9._-]*@leetcode\\.com$';
