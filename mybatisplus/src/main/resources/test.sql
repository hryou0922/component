CREATE TABLE `log_202108` (
`id`  bigint(20) NOT NULL ,
`user_id`  bigint(20) NOT NULL ,
`msg`  varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL ,
`create_time`  timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`id`)
)
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
;
