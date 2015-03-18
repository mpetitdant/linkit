# --- !Ups
update member set dtype = 'Sponsor', firstname = null, lastname = 'Informatique Systèmes Réseaux', logoUrl = "/public/images/logo-isr.jpg", level = 'BRONZE', publicProfile = true where lower(login) = 'sourcingisr';
update member set dtype = 'Sponsor', firstname = null, lastname = 'Elao', logoUrl = "/public/images/logo-elao.jpg", level = 'BRONZE', publicProfile = true where lower(login) = 'elao';

insert into sponsor_events(sponsor_id, events)
  select m.id, 'mixit15' from member m
  where m.dtype = 'Sponsor' and lower(m.login) IN ('sourcingisr','elao');


# --- !Downs
delete from sponsor_events
where events = 'mixit15' and sponsor_id = (
  select m.id from member m where m.dtype = 'Sponsor' and lower(m.login) IN ('sourcingisr','elao')
);

update member set dtype = 'Member', logoUrl = NULL where lower(login) IN ('sourcingisr','elao');
