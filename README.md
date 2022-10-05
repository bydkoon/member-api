# member-api 

### docker-compose up
 - application
 - db(mysql)

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