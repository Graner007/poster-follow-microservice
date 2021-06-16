ALTER TABLE IF EXISTS ONLY follow DROP CONSTRAINT IF EXISTS pk_follow_id CASCADE;

DROP TABLE IF EXISTS follow;
CREATE TABLE follow (
                        follower_person_id INTEGER NOT NULL,
                        followed_person_id INTEGER NOT NULL,
                        follow_date TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

ALTER TABLE ONLY follow
    ADD CONSTRAINT pk_follow_id PRIMARY KEY (follower_person_id, followed_person_id);