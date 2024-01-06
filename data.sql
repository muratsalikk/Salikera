-- H2 2.1.214;
;             
CREATE USER IF NOT EXISTS "SA" SALT 'efb3341b268d181f' HASH '232948e4583e545d0ab07ff7bb2e9e5ea59f238d3edf0efa1eac941a9d4f8cbb' ADMIN;         
CREATE SEQUENCE "PUBLIC"."IDGENERATOR" START WITH 1000 RESTART WITH 1200 INCREMENT BY 50;     
CREATE MEMORY TABLE "PUBLIC"."CONFIGURATION"(
    "VERSION" INTEGER NOT NULL,
    "CONFIGURATION_CATEGORY_ID" BIGINT NOT NULL,
    "ID" BIGINT NOT NULL,
    "TIME_STAMP" BIGINT NOT NULL,
    "C_VALUE" CHARACTER VARYING(255),
    "C_VALUE_ALLOWED" CHARACTER VARYING(255),
    "C_VALUE_DEFAULT" CHARACTER VARYING(255),
    "C_VALUE_TYPE" CHARACTER VARYING(255),
    "CONFIGURATION_NAME" CHARACTER VARYING(255),
    "TOOL_TIP" CHARACTER VARYING(255)
);  
ALTER TABLE "PUBLIC"."CONFIGURATION" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_2" PRIMARY KEY("ID");
-- 4 +/- SELECT COUNT(*) FROM PUBLIC.CONFIGURATION;           
INSERT INTO "PUBLIC"."CONFIGURATION" VALUES
(0, 1000, 1051, 268351326688900, '/hdlog/Presto/presto_0.283', '', '', 'Path', 'installation-directory', 'Installation directory'),
(0, 1000, 1052, 268351330230100, '/hdlog/Presto/data', '', '', 'Path', 'data-directory', 'Data directory for logs and spilling'),
(0, 1000, 1053, 268351330971700, 'AUTOMATIC', 'AUTOMATIC, PARTITIONED, BROADCAST', 'AUTOMATIC', 'string', 'join-distribution-type', 'The type of distributed join to use.'),
(0, 1000, 1054, 268351331581100, 'true', '', 'true', 'boolean', 'redistribute-writes', 'This property enables redistribution of data before writing.');    
CREATE MEMORY TABLE "PUBLIC"."CONFIGURATION_CATEGORY"(
    "VERSION" INTEGER NOT NULL,
    "ID" BIGINT NOT NULL,
    "CATEGORY_NAME" CHARACTER VARYING(255)
);            
ALTER TABLE "PUBLIC"."CONFIGURATION_CATEGORY" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_6" PRIMARY KEY("ID");       
-- 8 +/- SELECT COUNT(*) FROM PUBLIC.CONFIGURATION_CATEGORY;  
INSERT INTO "PUBLIC"."CONFIGURATION_CATEGORY" VALUES
(0, 1000, 'General'),
(0, 1001, 'Memory Management'),
(0, 1002, 'Spilling'),
(0, 1003, 'Exchange'),
(0, 1004, 'Task'),
(0, 1005, 'Node Scheduler'),
(0, 1006, 'Optimizer'),
(0, 1007, 'Miscellaneous');          
CREATE MEMORY TABLE "PUBLIC"."SERVER"(
    "IS_COORDINATOR" INTEGER,
    "VERSION" INTEGER NOT NULL,
    "CPU_CORES" BIGINT NOT NULL,
    "CPU_USAGE" BIGINT NOT NULL,
    "CPU_USAGE_PRESTO" BIGINT NOT NULL,
    "ID" BIGINT NOT NULL,
    "LAST_UPDATE_TIME" BIGINT NOT NULL,
    "MEMORY" BIGINT NOT NULL,
    "MEMORY_USAGE" BIGINT NOT NULL,
    "MEMORY_USAGE_PRESTO" BIGINT NOT NULL,
    "PRESTO_DATA_DISK_USAGE" BIGINT NOT NULL,
    "PRESTO_DATA_DISK_USAGE_PRESTO" BIGINT NOT NULL,
    "THREAD_COUNT" BIGINT NOT NULL,
    "THREAD_COUNT_PRESTO" BIGINT NOT NULL,
    "HOST_NAME" CHARACTER VARYING(255),
    "IP" CHARACTER VARYING(255),
    "JAVA_VERSION" CHARACTER VARYING(255),
    "NODE_ID" CHARACTER VARYING(255),
    "OSVERSION" CHARACTER VARYING(255),
    "PRESTO_BIN_DIRECTORY" CHARACTER VARYING(255),
    "PRESTO_DATA_DIRECTORY" CHARACTER VARYING(255),
    "PRESTO_VERSION" CHARACTER VARYING(255),
    "STATUS" CHARACTER VARYING(255),
    "USER_NAME" CHARACTER VARYING(255)
); 
ALTER TABLE "PUBLIC"."SERVER" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_91" PRIMARY KEY("ID");      
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.SERVER;  
INSERT INTO "PUBLIC"."SERVER" VALUES
(1, 0, 48, 17, 9, 1101, 268351332224000, 320000, 290000, 180000, 200, 39384, 600, 150, 'frdapppd', '10.25.207.80', '1.8_201', '303030-32jdfks-dfskajf-kdfs', 'Redhat Maipo 7.9', '/hdlog/Presto/presto_01', '/hdlog/Presto/data', '0.280.8', 'Running', 'fmsdev');      
ALTER TABLE "PUBLIC"."SERVER" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_9" CHECK(("IS_COORDINATOR" <= 1)
    AND ("IS_COORDINATOR" >= 0)) NOCHECK; 
ALTER TABLE "PUBLIC"."CONFIGURATION" ADD CONSTRAINT "PUBLIC"."FKOFW010CUDC49D0RBE1TXBMEDP" FOREIGN KEY("CONFIGURATION_CATEGORY_ID") REFERENCES "PUBLIC"."CONFIGURATION_CATEGORY"("ID") NOCHECK;               
