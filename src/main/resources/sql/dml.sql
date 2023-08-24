INSERT INTO review(review_no, review_title, review_content, book_mark_cnt, like_cnt, report_cnt, member_no, tag_no)
VALUES (1, '매실 못먹음', '컴프즈 문닫음', 0,0,0,1,1),
       (2, '두번째 리뷰', '두번째 내용', 0, 0, 0, 2, 2),
       (3, '세번째 리뷰', '세번째 내용', 0, 0, 0, 3, 3),
       (4, '네번째 리뷰', '네번째 내용', 0, 0, 0, 4, 4),
       (5, '다섯번째 리뷰', '다섯번째 내용', 0, 0, 0, 5, 5),
       (6, '여섯번째 리뷰', '여섯번째 내용', 0, 0, 0, 6, 6),
       (7, '일곱번째 리뷰', '일곱번째 내용', 0, 0, 0, 7, 7),
       (8, '여덟번째 리뷰', '여덟번째 내용', 0, 0, 0, 8, 8),
       (9, '아홉번째 리뷰', '아홉번째 내용', 0, 0, 0, 9, 9),
       (10, '열번째 리뷰', '열번째 내용', 0, 0, 0, 10, 10),
       (11, '열한번째 리뷰', '열한번째 내용', 0, 0, 0, 11, 11),
       (12, '열두번째 리뷰', '열두번째 내용', 0, 0, 0, 12, 12),
       (13, '열세번째 리뷰', '열세번째 내용', 0, 0, 0, 13, 13),
       (14, '열네번째 리뷰', '열네번째 내용', 0, 0, 0, 14, 14),
       (15, '열다섯번째 리뷰', '열다섯번째 내용', 0, 0, 0, 15, 15);

INSERT INTO review_likes(like_no, is_liked, member_no, review_no)
VALUES (1, False, 1, 15),
       (2, true, 2, 15);

insert into comment(comment_no, comment_content, member_no, review_no)
values (1, '댓글 1', 1, 1),
       (2, '댓글 2', 2, 1);

INSERT INTO achievements_tb (created_at, achievement_description, achievement_name, last_modified_at)
VALUES ('2023-08-20 22:04:28.000000', '좋아요 10개 달성', '좋아요 10개 달성', '2023-08-20 22:04:55.000000'),
       ('2023-08-20 22:04:28.000000', '리뷰 첫 작성', '리뷰 첫 작성', '2023-08-20 22:04:55.000000'),
       ('2023-08-20 22:04:28.000000', '리뷰 답글 작성', '리뷰 답글 작성', '2023-08-20 22:04:55.000000');

INSERT INTO attachments_tb (attachment_no, attachment_category, attachment_changed_name, attachment_original_name, attachment_url)
VALUES (1, 'achievements', '슈퍼스타코기', '슈퍼스타코기', '/assets/img/'),
       (2, 'achievements', '키보드치는 코기', '키보드치는 코기', '/assets/img/'),
       (3, 'achievements', '모니터앞 코기', '모니터앞 코기', '/assets/img/');
