-- 코드를 입력하세요
SELECT ub.TITLE, ub.BOARD_ID, ur.REPLY_ID, ur.WRITER_ID, ur.CONTENTS, 
date_format(ur.CREATED_DATE,'%Y-%m-%d') as CREATED_DATE
from USED_GOODS_BOARD as ub
join USED_GOODS_REPLY as ur on ub.BOARD_ID = ur.BOARD_ID
where year(ub.CREATED_DATE)=2022 and month(ub.CREATED_DATE) = 10
order by ur.CREATED_DATE, ub.TITLE;