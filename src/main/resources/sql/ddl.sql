create table review (
                        review_no bigint not null auto_increment,
                        book_mark_cnt bigint,
                        like_cnt bigint,
                        report_cnt bigint,
                        review_content varchar(255),
                        review_title varchar(255),
                        member_no bigint,
                        tag_no bigint,
                        primary key (review_no)
)