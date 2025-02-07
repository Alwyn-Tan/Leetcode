SELECT * FROM cinema
where description != 'boring' AND  mod(id,2) = 1
ORDER BY rating DESC