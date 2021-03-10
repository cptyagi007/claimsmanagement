insert into policy (policy_id, policy_name, sum_insured, premium, tenure) values (1,'Easy Health', 920000, 100000, 5);
insert into policy (policy_id, policy_name, sum_insured, premium, tenure) values (2,'Cancer Care', 100000, 200000, 3);
insert into policy (policy_id, policy_name, sum_insured, premium, tenure) values (3,'Protect Health', 2000000, 150000, 10);
insert into policy (policy_id, policy_name, sum_insured, premium, tenure) values (4,'Optima Cash', 500000, 50000, 5);
insert into policy (policy_id, policy_name, sum_insured, premium, tenure) values (5,'Dengue Care', 300000, 50000, 5);

insert into benefits( benefit_id, benefit) values (1, 'Critical Illness');
insert into benefits ( benefit_id, benefit) values (2, 'Tax Benefits');
insert into benefits ( benefit_id, benefit) values (3, 'Surgical Benefits');
insert into benefits ( benefit_id, benefit) values (4, 'Daily hospital cash');
insert into benefits ( benefit_id, benefit) values (5, 'Child Birth');
insert into benefits ( benefit_id, benefit) values (6, 'Death Benefit');
insert into benefits ( benefit_id, benefit) values (7, 'ICU');
insert into benefits ( benefit_id, benefit) values (8, 'cancer cover @nominal cost');


insert into provider (provider_id, provider_name, location) values (1001, 'Sharl', 'Agra');
insert into provider (provider_id, provider_name, location) values (1002, 'MAX', 'Noida');
insert into provider (provider_id, provider_name, location) values (1003, 'Jaypee','Noida');
insert into provider (provider_id, provider_name, location) values (1004, 'AIIMS', 'Delhi');
insert into provider (provider_id, provider_name, location) values (1005, 'Max', 'Delhi');
insert into provider (provider_id, provider_name, location) values (1006, 'Apolo', 'Delhi');
insert into provider (provider_id, provider_name, location) values (1007, 'Pushpanjali hospital','Agra');


insert into policy_benefit (policy_id, benefit_id) values (1, 1);
insert into policy_benefit (policy_id, benefit_id) values (1, 2);
insert into policy_benefit (policy_id, benefit_id) values (1, 3);
insert into policy_benefit (policy_id, benefit_id) values (2, 2);
insert into policy_benefit (policy_id, benefit_id) values (2, 8);
insert into policy_benefit (policy_id, benefit_id) values (3, 1);
insert into policy_benefit (policy_id, benefit_id) values (3, 7);
insert into policy_benefit (policy_id, benefit_id) values (4, 6);
insert into policy_benefit (policy_id, benefit_id) values (4, 7);
insert into policy_benefit (policy_id, benefit_id) values (4, 2);
insert into policy_benefit (policy_id, benefit_id) values (5, 4);

insert into provider_policy(providerid, policyid) values (1001, 1);
insert into provider_policy(providerid, policyid) values (1002, 2);
insert into provider_policy(providerid, policyid) values (1003, 3);
insert into provider_policy(providerid, policyid) values (1004, 4);
insert into provider_policy(providerid, policyid) values (1005, 5);
insert into provider_policy(providerid, policyid) values (1006, 1);
insert into provider_policy(providerid, policyid) values (1007, 3);
insert into provider_policy(providerid, policyid) values (1005, 3);
insert into provider_policy(providerid, policyid) values (1003, 1);
insert into provider_policy(providerid, policyid) values (1002, 1);
insert into provider_policy(providerid, policyid) values (1001, 5);
insert into provider_policy(providerid, policyid) values (1005, 4);


insert into member(member_id, amount,subscription_date) values (1,200000,'2019-11-15');
insert into member(member_id, amount,subscription_date) values (2,300000,'2018-04-10');
insert into member(member_id, amount,subscription_date) values (3,200000,'2017-10-10');
insert into member(member_id, amount,subscription_date) values (4,800000,'2011-06-05');
insert into member(member_id, amount,subscription_date) values (5,1000000,'2020-10-10');

insert into member_policy(member_id, policy_id) values (1,1);
insert into member_policy(member_id, policy_id) values (1,3);
insert into member_policy(member_id, policy_id) values (2,5);
insert into member_policy(member_id, policy_id) values (3,4);
insert into member_policy(member_id, policy_id) values (3,2);
insert into member_policy(member_id, policy_id) values (4,1);
insert into member_policy(member_id, policy_id) values (5,1);
insert into member_policy(member_id, policy_id) values (5,4);







