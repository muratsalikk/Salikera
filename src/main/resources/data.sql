insert into CONFIGURATION_CATEGORY  (ID, VERSION,CATEGORY_NAME)
(1,1,'General'),
(2,1,'Memory Management'),
(3,1,'Spilling'),
(4,1,'Exchange'),
(5,1,'Task'),
(6,1,'Node Scheduler'),
(7,1,'Optimizer'),
(8,1,'Miscellaneous');

insert into CONFIGURATION (ID, VERSION, CONFIGURATION_CATEGORY_ID, CONFIGURATION_NAME, , C_VALUE, C_VALUE_ALLOWED, C_VALUE_DEFAULT, C_VALUE_TYPE, TOOL_TIP, TIME_STAMP)
(9,1,1,'installation-directory', 'Path', '', '', '/hdlog/Presto/presto_0.283', 'Installation directory',0),
(10,1,1,'data-directory', 'Path', '', '', '/hdlog/Presto/data', 'Data directory for logs and spilling',0),
(11,1,1,'installation-directory', 'Path', '', '', '/hdlog/Presto/presto_0.283', 'Installation directory',0),
(12,1,1,'installation-directory', 'Path', '', '', '/hdlog/Presto/presto_0.283', 'Installation directory',0),



insert into CONFIGURATION  (ID, IS_COORDINATOR, VERSION, CPU_CORES, CPU_USAGE_PRESTO,  LAST_UPDATE_TIME, MEMORY, MEMORY_USAGE, MEMORY_USAGE_PRESTO, PRESTO_DATA_DISK_USAGE, PRESTO_DATA_DISK_USAGE_PRESTO, THREAD_COUNT, THREAD_COUNT_PRESTO, HOST_NAME, IP, JAVA_VERSION, NODE_ID, OSVERSION, PRESTO_BIN_DIRECTORY, PRESTO_DATA_DIRECTORY, PRESTO_VERSION, STATUS, USER_NAME, ) values
(110)


/* INSERT INTO "STATUS" (ID, VERSION, NAME) VALUES
(1, 1, 'Imported lead'),
(2, 1, 'Not contacted'),
(3, 1, 'Contacted'),
(4, 1, 'Customer'),
(5, 1, 'Closed (lost)');
INSERT INTO "COMPANY" (ID, VERSION, NAME) VALUES
(6, 1, 'Phillips Van Heusen Corp.'),
(7, 1, 'Avaya Inc.'),
(8, 1, 'Laboratory Corporation of America Holdings'),
(9, 1, 'AutoZone, Inc.'),
(10, 1, 'Linens ''n Things Inc.');
INSERT INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES
(11, 1, 'eula.lane@jigrormo.ye', 'Eula', 'Lane', 8, 1),
(12, 1, 'barry.rodriquez@zun.mm', 'Barry', 'Rodriquez', 7, 5),
(13, 1, 'eugenia.selvi@capfad.vn', 'Eugenia', 'Selvi', 6, 3),
(14, 1, 'alejandro.miles@dec.bn', 'Alejandro', 'Miles', 10, 3),
(15, 1, 'cora.tesi@bivo.yt', 'Cora', 'Tesi', 6, 4),
(16, 1, 'marguerite.ishii@judbilo.gn', 'Marguerite', 'Ishii', 10, 2),
(17, 1, 'mildred.jacobs@joraf.wf', 'Mildred', 'Jacobs', 8, 1),
(18, 1, 'gene.goodman@kem.tl', 'Gene', 'Goodman', 8, 5),
(19, 1, 'lettie.bennett@odeter.bb', 'Lettie', 'Bennett', 6, 1),
(20, 1, 'mabel.leach@lisohuje.vi', 'Mabel', 'Leach', 10, 2),
(21, 1, 'jordan.miccinesi@duod.gy', 'Jordan', 'Miccinesi', 8, 3),
(22, 1, 'marie.parkes@nowufpus.ph', 'Marie', 'Parkes', 7, 1),
(23, 1, 'rose.gray@kagu.hr', 'Rose', 'Gray', 9, 4),
(24, 1, 'garrett.stokes@fef.bg', 'Garrett', 'Stokes', 9, 3),
(25, 1, 'barbara.matthieu@derwogi.jm', 'Barbara', 'Matthieu', 7, 5),
(26, 1, 'jean.rhodes@wehovuce.gu', 'Jean', 'Rhodes', 7, 3),
(27, 1, 'jack.romoli@zamum.bw', 'Jack', 'Romoli', 6, 4),
(28, 1, 'pearl.holden@dunebuh.cr', 'Pearl', 'Holden', 8, 1),
(29, 1, 'belle.montero@repiwid.si', 'Belle', 'Montero', 9, 5),
(30, 1, 'olive.molina@razuppa.ga', 'Olive', 'Molina', 6, 2),
(31, 1, 'minerva.todd@kulmenim.ad', 'Minerva', 'Todd', 9, 3),
(32, 1, 'bobby.pearson@ib.kg', 'Bobby', 'Pearson', 9, 1),
(33, 1, 'larry.ciappi@ba.lk', 'Larry', 'Ciappi', 10, 2),
(34, 1, 'ronnie.salucci@tohhij.lv', 'Ronnie', 'Salucci', 9, 1),
(35, 1, 'walter.grossi@tuvo.sa', 'Walter', 'Grossi', 9, 1);
INSERT INTO "CONTACT" (ID, VERSION, EMAIL,FIRST_NAME,LAST_NAME,COMPANY_ID,STATUS_ID) VALUES
(36, 1, 'frances.koopmans@foga.tw', 'Frances', 'Koopmans', 7, 5),
(37, 1, 'frances.fujimoto@uswuzzub.jp', 'Frances', 'Fujimoto', 6, 5),
(38, 1, 'olivia.vidal@hivwerip.vc', 'Olivia', 'Vidal', 9, 2),
(39, 1, 'edna.henry@gugusu.rw', 'Edna', 'Henry', 8, 4),
(40, 1, 'lydia.brun@zedekak.md', 'Lydia', 'Brun', 7, 3),
(41, 1, 'jay.blake@ral.mk', 'Jay', 'Blake', 10, 4),
(42, 1, 'isabel.serafini@turuhu.bh', 'Isabel', 'Serafini', 10, 1),
(43, 1, 'rebecca.carter@omjo.et', 'Rebecca', 'Carter', 8, 4),
(44, 1, 'maurice.fabbrini@rig.bh', 'Maurice', 'Fabbrini', 9, 3),
(45, 1, 'ollie.turnbull@sicewap.org', 'Ollie', 'Turnbull', 6, 1),
(46, 1, 'jerry.hopkins@fo.mh', 'Jerry', 'Hopkins', 9, 5),
(47, 1, 'nora.lyons@gegijap.na', 'Nora', 'Lyons', 10, 1),
(48, 1, 'anne.weis@kuvesa.pe', 'Anne', 'Weis', 7, 4),
(49, 1, 'louise.gauthier@lapahu.mt', 'Louise', 'Gauthier', 6, 2),
(50, 1, 'lloyd.fani@zev.ru', 'Lloyd', 'Fani', 8, 1),
(51, 1, 'maud.dunn@nabeaga.ni', 'Maud', 'Dunn', 6, 1),
(52, 1, 'henry.gigli@kaot.ps', 'Henry', 'Gigli', 6, 5),
(53, 1, 'virgie.werner@tawuctuj.cf', 'Virgie', 'Werner', 10, 4),
(54, 1, 'gregory.cozzi@eh.ru', 'Gregory', 'Cozzi', 8, 2),
(55, 1, 'lucinda.gil@fajjusuz.kr', 'Lucinda', 'Gil', 7, 5),
(56, 1, 'gertrude.verbeek@pave.cc', 'Gertrude', 'Verbeek', 6, 5),
(57, 1, 'mattie.graham@ispaviw.gt', 'Mattie', 'Graham', 7, 2),
(58, 1, 'bryan.shaw@ha.ee', 'Bryan', 'Shaw', 9, 1),
(59, 1, 'essie.adams@iliat.cw', 'Essie', 'Adams', 8, 5),
(60, 1, 'gary.osborne@do.ga', 'Gary', 'Osborne', 7, 5); */