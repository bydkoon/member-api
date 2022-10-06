# member-api 

### docker-compose up
 - application
 - db(mysql) 

### DB table - ddl-auto: update (application 실행시 MemberDB 생성)
 create table member (
     idx bigint not null auto_incremnt,
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     email varchar(255) not null,
     member_id varchar(255) not null,
     password varchar(255) not null,
     phone varchar(255) not null,
     primary key (idx)
     ) engine=InnoDB

### front-end page 
 - localhost:8080/index

### request API
 - request.http 
   - [GET] memberId
   - [POST] signup

### test case
- Member dummy data class
    - MemberDummy
- API TestCase 
  - ApiApplicaionTests 테스트 실행
  
- Member TestCase
  - MemberRequestTest 테스트 실행

### enctypt
 - password
   - sha256
 - member info
   - aes256