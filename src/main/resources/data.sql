insert into reviewer values(1, 'mandy', true);
insert into reviewer values(2, 'boorownie', true);
insert into reviewer values(3, 'wotjd243', true);
insert into reviewer values(4, 'brainbackdoor', true);
insert into reviewer values(5, 'testrace', true);
insert into reviewer values(6, 'EungyuCho', true);

insert into tech_stack values(1, 'java');
insert into tech_stack values(2, 'javascript');
insert into tech_stack values(3, 'springframework');
insert into tech_stack values(4, 'jpa');
insert into tech_stack values(5, 'mysql');
insert into tech_stack values(6, 'kotlin');

insert into reviewer_tech_stack values(1, 1, 1);
insert into reviewer_tech_stack values(2, 1, 2);
insert into reviewer_tech_stack values(3, 1, 3);
insert into reviewer_tech_stack values(4, 2, 2);
insert into reviewer_tech_stack values(5, 3, 1);
insert into reviewer_tech_stack values(6, 3, 2);
insert into reviewer_tech_stack values(7, 3, 3);
insert into reviewer_tech_stack values(8, 3, 4);
insert into reviewer_tech_stack values(9, 3, 5);
insert into reviewer_tech_stack values(10, 4, 1);
insert into reviewer_tech_stack values(11, 5, 1);
insert into reviewer_tech_stack values(12, 5, 3);
insert into reviewer_tech_stack values(13, 6, 3);
insert into reviewer_tech_stack values(14, 6, 6);

insert into project values(X'c387663beebb41f088eeab50ca824022', 1, 'papaco', false, 'papaco project', false, 1);
insert into project values(X'4dac95fa01e443d99feb06f63cd97bb3', 2, 'member', false, 'member project', false, 1);
insert into project values(X'2ce35034e1554385a627550e771c63ec', 3, 'mate', false, 'mate project', false, 1);
insert into project values(X'c16d009d960248298cd139a21b632974', 4, 'review', false, 'review project', false, 1);
insert into project values(X'4a5d5fa257744cc5816947e0a691eea7', 5, 'query', false, 'query project', false, 1);

insert into project_tech_stack values(1, X'c387663beebb41f088eeab50ca824022', 1);
insert into project_tech_stack values(2, X'c387663beebb41f088eeab50ca824022', 2);
insert into project_tech_stack values(3, X'c387663beebb41f088eeab50ca824022', 3);

insert into project_tech_stack values(4, X'4dac95fa01e443d99feb06f63cd97bb3', 2);
insert into project_tech_stack values(5, X'4dac95fa01e443d99feb06f63cd97bb3', 3);
insert into project_tech_stack values(6, X'4dac95fa01e443d99feb06f63cd97bb3', 4);

insert into project_tech_stack values(7, X'2ce35034e1554385a627550e771c63ec', 3);
insert into project_tech_stack values(8, X'2ce35034e1554385a627550e771c63ec', 4);
insert into project_tech_stack values(9, X'2ce35034e1554385a627550e771c63ec', 5);

insert into project_tech_stack values(10, X'c16d009d960248298cd139a21b632974', 1);
insert into project_tech_stack values(11, X'c16d009d960248298cd139a21b632974', 3);
insert into project_tech_stack values(12, X'c16d009d960248298cd139a21b632974', 4);

insert into project_tech_stack values(13, X'4a5d5fa257744cc5816947e0a691eea7', 2);
insert into project_tech_stack values(14, X'4a5d5fa257744cc5816947e0a691eea7', 4);
insert into project_tech_stack values(15, X'4a5d5fa257744cc5816947e0a691eea7', 5);

-- [mate < project]
-- 1
insert into mate values(X'b061adb976a1484bbeab4f8cf4d7e798', '2023-01-01 13:00:00', '2023-01-02 13:00:00', 'FINISHED', X'c387663beebb41f088eeab50ca824022', 1);
insert into mate values(X'f0839a24959541b68d6271a530cab586', '2023-01-03 13:00:00', '2023-01-04 13:00:00', 'JOINED', X'c387663beebb41f088eeab50ca824022', 2);

-- 2
insert into mate values(X'c866c66c18af4a9ca5fc81d0cfb9db37', '2023-01-02 13:00:00', '2023-01-03 13:00:00', 'FINISHED', X'4dac95fa01e443d99feb06f63cd97bb3', 3);
insert into mate values(X'c2eb46fc5f1f4839af233ce83780ce08', '2023-01-05 13:00:00', '2023-01-06 13:00:00', 'JOINED', X'4dac95fa01e443d99feb06f63cd97bb3', 4);

-- 3
insert into mate values(X'c07a5ba84bab4291bb91da5746806ed8', '2023-01-05 13:00:00', '2023-01-06 13:00:00', 'FINISHED', X'2ce35034e1554385a627550e771c63ec', 1);
insert into mate values(X'3e01b471e57a4bb1b41e79112a5c37c3', '2023-01-07 13:00:00', '2023-01-09 13:00:00', 'JOINED', X'2ce35034e1554385a627550e771c63ec', 5);

-- 4
insert into mate values(X'3b8e510a2e99494189ab45bc937758f1', '2023-01-05 13:00:00', '2023-01-07 13:00:00', 'FINISHED', X'c16d009d960248298cd139a21b632974', 3);
insert into mate values(X'ec857e23d2c14905a286f0431da2d7ee', '2023-01-10 13:00:00', '2023-01-13 13:00:00', 'JOINED', X'c16d009d960248298cd139a21b632974', 4);

-- 5
insert into mate values(X'ddffb45a02814fe5b5c84e63ca5b8cfd', '2023-01-11 13:00:00', '2023-01-13 13:00:00', 'FINISHED', X'4a5d5fa257744cc5816947e0a691eea7', 1);
insert into mate values(X'd22cc3846d204dca855a99695f619835', '2023-01-15 13:00:00', '2023-01-19 13:00:00', 'JOINED', X'4a5d5fa257744cc5816947e0a691eea7', 6);


-- [review < mate]
-- 1
insert into review values(X'1cd3d84218df4969931d836905f8ee60', 'COMPLETED', X'b061adb976a1484bbeab4f8cf4d7e798');
insert into review values(X'3f088b45e24d48d8be951670b5f1f5ec', 'COMPLETED', X'b061adb976a1484bbeab4f8cf4d7e798');
insert into review values(X'605ae61a96b94d08820b0af37545a0ba', 'COMPLETED', X'b061adb976a1484bbeab4f8cf4d7e798');
insert into review values(X'ac7b2d1708604fd8b8e225d9710a40cb', 'COMPLETED', X'b061adb976a1484bbeab4f8cf4d7e798');
insert into review values(X'0ef3f02d0c3d4d6b8bbcce49e4fa2f08', 'COMPLETED', X'b061adb976a1484bbeab4f8cf4d7e798');
insert into review values(X'ac3f1b5fecc94948bfc95c51d2183b98', 'DEMANDED', X'b061adb976a1484bbeab4f8cf4d7e798');

insert into review values(X'5475e9bd6ada4ba986dd629b9f787da6', 'COMPLETED', X'f0839a24959541b68d6271a530cab586');
insert into review values(X'c7a33d5c258c4ce5a6c55aba8651fd8f', 'COMPLETED', X'f0839a24959541b68d6271a530cab586');
insert into review values(X'9bb2bceceb644989bf05445808bd448b', 'COMPLETED', X'f0839a24959541b68d6271a530cab586');
insert into review values(X'999a868b306947c1afd25ea61b55a73c', 'COMPLETED', X'f0839a24959541b68d6271a530cab586');
insert into review values(X'4a282cea7a1c4922ad6384e87d81133d', 'COMPLETED', X'f0839a24959541b68d6271a530cab586');
insert into review values(X'65030de2b366422298bab0a357d4f106', 'COMPLETED', X'f0839a24959541b68d6271a530cab586');
insert into review values(X'322057f2f9bf4cfa953eaaa4083a91ab', 'COMPLETED', X'f0839a24959541b68d6271a530cab586');

-- 2
insert into review values(X'51669bd70d704c26bdbe3ca4d15bff65', 'COMPLETED', X'c866c66c18af4a9ca5fc81d0cfb9db37');
insert into review values(X'5f68450d04aa48438fae280f3add9093', 'COMPLETED', X'c866c66c18af4a9ca5fc81d0cfb9db37');
insert into review values(X'26078efa9916401d9f69c3829d404131', 'COMPLETED', X'c866c66c18af4a9ca5fc81d0cfb9db37');
insert into review values(X'a79d2e268b03413bb986e7bf29511d60', 'COMPLETED', X'c866c66c18af4a9ca5fc81d0cfb9db37');
insert into review values(X'4becdd88aac04b248fa7d73c7a18923f', 'COMPLETED', X'c866c66c18af4a9ca5fc81d0cfb9db37');

insert into review values(X'8779f44f59974a61b9a628d9ac850140', 'COMPLETED', X'c2eb46fc5f1f4839af233ce83780ce08');
insert into review values(X'fe440f55a24e41a7b12986562f5d3922', 'DEMANDED', X'c2eb46fc5f1f4839af233ce83780ce08');

-- 3
insert into review values(X'c99c6e8572c04567b375ca65a9496c40', 'COMPLETED', X'c07a5ba84bab4291bb91da5746806ed8');
insert into review values(X'e7db8da70fc94f60aec9c5ca966231d2', 'COMPLETED', X'c07a5ba84bab4291bb91da5746806ed8');
insert into review values(X'7ee5f792bdf745c7ab5c7737c4f11309', 'COMPLETED', X'c07a5ba84bab4291bb91da5746806ed8');
insert into review values(X'c6847a59465f41ae9aee887b6c255cc6', 'COMPLETED', X'c07a5ba84bab4291bb91da5746806ed8');

insert into review values(X'cb6ef38c94c0408fa871c8593215378c', 'COMPLETED', X'3e01b471e57a4bb1b41e79112a5c37c3');
insert into review values(X'f9ec59ef46ed4fe4b92acd0085ecf067', 'DEMANDED', X'3e01b471e57a4bb1b41e79112a5c37c3');

-- 4
insert into review values(X'38187e4eb716416ba4f6f3774947a416', 'COMPLETED', X'3b8e510a2e99494189ab45bc937758f1');
insert into review values(X'5bca391f1a154bfdb3eb3c0330ce1d40', 'COMPLETED', X'3b8e510a2e99494189ab45bc937758f1');

insert into review values(X'ef09b94a17884a73b529f2f8d9277d93', 'DEMANDED', X'ec857e23d2c14905a286f0431da2d7ee');

-- 5
insert into review values(X'dcd2c903e4fa4b4589193198cbba6d7e', 'COMPLETED', X'ddffb45a02814fe5b5c84e63ca5b8cfd');
insert into review values(X'06d8a8b27fab4823af979309b795a7e9', 'COMPLETED', X'ddffb45a02814fe5b5c84e63ca5b8cfd');
insert into review values(X'60d2a8e7cecb4f5cb56cea423cf1828b', 'COMPLETED', X'ddffb45a02814fe5b5c84e63ca5b8cfd');
insert into review values(X'1c3d16e878244c18a0d9ca2256f27f27', 'COMPLETED', X'ddffb45a02814fe5b5c84e63ca5b8cfd');
insert into review values(X'842a739d799540688ccffe565f968e26', 'COMPLETED', X'ddffb45a02814fe5b5c84e63ca5b8cfd');
insert into review values(X'7ac7d789c2834c55898cbc95cd854ff3', 'COMPLETED', X'ddffb45a02814fe5b5c84e63ca5b8cfd');

insert into review values(X'60a6579580c247eb8b5f27c9f24a90cf', 'COMPLETED', X'd22cc3846d204dca855a99695f619835');
insert into review values(X'337b2fa7dbce4e18ad46ad65a6ac3cba', 'COMPLETED', X'd22cc3846d204dca855a99695f619835');
insert into review values(X'e6049c6d090b4ca49cd2a15352aec3ed', 'COMPLETED', X'd22cc3846d204dca855a99695f619835');
insert into review values(X'3e3ee1399fd0455396be434111d16a89', 'COMPLETED', X'd22cc3846d204dca855a99695f619835');
